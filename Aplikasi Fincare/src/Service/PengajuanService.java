<<<<<<< HEAD
package service;

import App.JPAProvider;
import java.util.List;
import Model.PengajuanBaris;
import model.PengajuanBantuan;

public class PengajuanService extends BaseService implements CrudService<PengajuanBantuan, Integer> {

    private static final int NOMINAL_SALDO = 2_500_000;

    @Override
    public PengajuanBantuan tambah(PengajuanBantuan t) {
        return tx(em -> {
            Long c = em.createQuery(
                "SELECT COUNT(p) FROM PengajuanBantuan p " +
                "WHERE p.pengguna.nik = :nik AND p.statusPengajuan = 'MENUNGGU'",
                Long.class
            ).setParameter("nik", t.getPengguna().getNik())
             .getSingleResult();

            if (c != null && c > 0) {
                throw new IllegalStateException("Masih ada pengajuan MENUNGGU. Batalkan dulu.");
            }

            t.setStatusPengajuan("MENUNGGU");
            if (t.getTanggalPengajuan() == null) {
                t.setTanggalPengajuan(java.time.LocalDateTime.now());
            }

            t.setAdmin(null);

            em.persist(t);
            return t;
        });
    }

    @Override
    public PengajuanBantuan temukan(Integer id) {
        var em = JPAProvider.em();
        try {
            return em.find(PengajuanBantuan.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<PengajuanBantuan> temukanSemua() {
        var em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT p FROM PengajuanBantuan p ORDER BY p.tanggalPengajuan",
                PengajuanBantuan.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public PengajuanBantuan perbarui(PengajuanBantuan t) {
        return tx(em -> em.merge(t));
    }

    @Override
    public boolean hapus(Integer id) {
        return tx(em -> {
            var x = em.find(PengajuanBantuan.class, id);
            if (x != null) {
                em.remove(x);
                return true;
            }
            return false;
        });
    }

    public List<PengajuanBaris> cariDenganAkun(String keyword) {
        final String k = (keyword == null) ? "" : keyword.trim().toLowerCase();
        var em = JPAProvider.em();
        try {
            String jpql =
                "SELECT new Model.PengajuanBaris(" +
                "  p.idPengajuan, " +
                "  a.nik, " +
                "  COALESCE(a.nama, ''), " +
                "  COALESCE(pg.pekerjaan, ''), " +
                "  COALESCE(pg.penghasilan, 0), " +
                "  COALESCE(p.bidangDiminati, ''), " +
                "  p.tanggalPengajuan, " +
                "  p.statusPengajuan, " +
                "  p.alasanPengajuan, " +
                "  p.idPelatihan, " + 
                "  adm.nik " +
                ") " +
                "FROM PengajuanBantuan p " +
                "LEFT JOIN p.pengguna a " +
                "LEFT JOIN Pengguna pg ON pg.nik = a.nik " +
                "LEFT JOIN p.admin adm ";

            if (!k.isEmpty()) {
                jpql += "WHERE (" +
                        "LOWER(COALESCE(a.nama, '')) LIKE :k OR " +
                        "LOWER(COALESCE(pg.pekerjaan, '')) LIKE :k OR " +
                        "LOWER(COALESCE(p.bidangDiminati, '')) LIKE :k OR " +
                        "LOWER(COALESCE(p.statusPengajuan, '')) LIKE :k" +
                        ") ";
            }

            jpql += "ORDER BY p.idPengajuan";

            var q = em.createQuery(jpql, PengajuanBaris.class);
            if (!k.isEmpty()) q.setParameter("k", "%" + k + "%");
                return q.getResultList();
        } finally {
            em.close();
        }
    }


    public void setStatus(Integer idPengajuan, String statusBaru, Integer nikAdminYgMemproses) {
        if (idPengajuan == null) 
            throw new IllegalArgumentException("id pengajuan kosong.");
        if (nikAdminYgMemproses == null) 
            throw new IllegalArgumentException("Sesi admin hilang.");

        String s = (statusBaru == null ? "" : statusBaru.trim().toUpperCase());
        if (!(s.equals("DITERIMA") || s.equals("DITOLAK") || s.equals("MENUNGGU"))) {
            throw new IllegalArgumentException("Status tidak valid: " + statusBaru);
        }

        tx(em -> {
            var p = em.find(model.PengajuanBantuan.class, idPengajuan);
            if (p == null) 
                throw new IllegalArgumentException("Pengajuan tidak ditemukan.");

            String statusLama = p.getStatusPengajuan();
            
            var adminRef = em.getReference(model.Admin.class, nikAdminYgMemproses);
            p.setAdmin(adminRef);
            p.setStatusPengajuan(s);
            em.merge(p);

            if (!"DITERIMA".equalsIgnoreCase(statusLama) && "DITERIMA".equalsIgnoreCase(s)) {
                Integer nikPengguna = p.getPengguna().getNik();

                var pengguna = em.find(
                    model.Pengguna.class, nikPengguna,
                    jakarta.persistence.LockModeType.PESSIMISTIC_WRITE
                );
                if (pengguna == null) {
                    throw new IllegalStateException("Data Pengguna belum dibuat untuk NIK: " + nikPengguna);
                }

                Integer saldo = pengguna.getSaldoAkun();
                if (saldo == null) saldo = 0;
                pengguna.setSaldoAkun(saldo + NOMINAL_SALDO);
                em.merge(pengguna);
            }

            if ("DITERIMA".equalsIgnoreCase(statusLama) && !"DITERIMA".equalsIgnoreCase(s)) {
                throw new IllegalStateException("Status sudah DITERIMA dan tidak boleh diubah.");
            }

            return null;
        });
    }

    public void ubahStatus(Integer idPengajuan, String statusBaru, Integer nikAdmin) {
        setStatus(idPengajuan, statusBaru, nikAdmin);
    }

    public void prosesPengajuan(int idPengajuan, int nikAdmin, String status) {
        setStatus(idPengajuan, status, nikAdmin);
    }

    public boolean hasPendingByNik(Integer nik) {
        var em = JPAProvider.em();
        try {
            Long c = em.createQuery(
                "SELECT COUNT(p) FROM PengajuanBantuan p " +
                "WHERE p.pengguna.nik = :nik AND p.statusPengajuan = 'MENUNGGU'",
                Long.class
            ).setParameter("nik", nik)
             .getSingleResult();
            return c != null && c > 0;
        } finally {
            em.close();
        }
    }

    public void batalkanPengajuan(Integer idPengajuan, Integer nikPengguna) {
        tx(em -> {
            var p = em.find(PengajuanBantuan.class, idPengajuan);
            if (p == null) 
                throw new IllegalArgumentException("Pengajuan tidak ditemukan.");
            if (!p.getPengguna().getNik().equals(nikPengguna))
                throw new SecurityException("Tidak boleh membatalkan pengajuan milik orang lain.");
            if (!"MENUNGGU".equalsIgnoreCase(p.getStatusPengajuan()))
                throw new IllegalStateException("Hanya pengajuan MENUNGGU yang bisa dibatalkan.");

            em.remove(p);
            return null;
        });
    }
}
=======
package service;

import App.JPAProvider;
import java.util.List;
import Model.PengajuanBaris;
import model.PengajuanBantuan;

public class PengajuanService extends BaseService implements CrudService<PengajuanBantuan, Integer> {

    private static final int NOMINAL_SALDO = 2_500_000;

    @Override
    public PengajuanBantuan tambah(PengajuanBantuan t) {
        return tx(em -> {
            Long c = em.createQuery(
                "SELECT COUNT(p) FROM PengajuanBantuan p " +
                "WHERE p.pengguna.nik = :nik AND p.statusPengajuan = 'MENUNGGU'",
                Long.class
            ).setParameter("nik", t.getPengguna().getNik())
             .getSingleResult();

            if (c != null && c > 0) {
                throw new IllegalStateException("Masih ada pengajuan MENUNGGU. Batalkan dulu.");
            }

            t.setStatusPengajuan("MENUNGGU");
            if (t.getTanggalPengajuan() == null) {
                t.setTanggalPengajuan(java.time.LocalDateTime.now());
            }

            t.setAdmin(null);

            em.persist(t);
            return t;
        });
    }

    @Override
    public PengajuanBantuan temukan(Integer id) {
        var em = JPAProvider.em();
        try {
            return em.find(PengajuanBantuan.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<PengajuanBantuan> temukanSemua() {
        var em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT p FROM PengajuanBantuan p ORDER BY p.tanggalPengajuan",
                PengajuanBantuan.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public PengajuanBantuan perbarui(PengajuanBantuan t) {
        return tx(em -> em.merge(t));
    }

    @Override
    public boolean hapus(Integer id) {
        return tx(em -> {
            var x = em.find(PengajuanBantuan.class, id);
            if (x != null) {
                em.remove(x);
                return true;
            }
            return false;
        });
    }

    public List<PengajuanBaris> cariDenganAkun(String keyword) {
        final String k = (keyword == null) ? "" : keyword.trim().toLowerCase();
        var em = JPAProvider.em();
        try {
            String jpql =
                "SELECT new Model.PengajuanBaris(" +
                "  p.idPengajuan, " +
                "  a.nik, " +
                "  COALESCE(a.nama, ''), " +
                "  COALESCE(pg.pekerjaan, ''), " +
                "  COALESCE(pg.penghasilan, 0), " +
                "  COALESCE(p.bidangDiminati, ''), " +
                "  p.tanggalPengajuan, " +
                "  p.statusPengajuan, " +
                "  p.alasanPengajuan, " +
                "  p.idPelatihan, " + 
                "  adm.nik " +
                ") " +
                "FROM PengajuanBantuan p " +
                "LEFT JOIN p.pengguna a " +
                "LEFT JOIN Pengguna pg ON pg.nik = a.nik " +
                "LEFT JOIN p.admin adm ";

            if (!k.isEmpty()) {
                jpql += "WHERE (" +
                        "LOWER(COALESCE(a.nama, '')) LIKE :k OR " +
                        "LOWER(COALESCE(pg.pekerjaan, '')) LIKE :k OR " +
                        "LOWER(COALESCE(p.bidangDiminati, '')) LIKE :k OR " +
                        "LOWER(COALESCE(p.statusPengajuan, '')) LIKE :k" +
                        ") ";
            }

            jpql += "ORDER BY p.idPengajuan";

            var q = em.createQuery(jpql, PengajuanBaris.class);
            if (!k.isEmpty()) q.setParameter("k", "%" + k + "%");
                return q.getResultList();
        } finally {
            em.close();
        }
    }


    public void setStatus(Integer idPengajuan, String statusBaru, Integer nikAdminYgMemproses) {
        if (idPengajuan == null) 
            throw new IllegalArgumentException("id pengajuan kosong.");
        if (nikAdminYgMemproses == null) 
            throw new IllegalArgumentException("Sesi admin hilang.");

        String s = (statusBaru == null ? "" : statusBaru.trim().toUpperCase());
        if (!(s.equals("DITERIMA") || s.equals("DITOLAK") || s.equals("MENUNGGU"))) {
            throw new IllegalArgumentException("Status tidak valid: " + statusBaru);
        }

        tx(em -> {
            var p = em.find(model.PengajuanBantuan.class, idPengajuan);
            if (p == null) 
                throw new IllegalArgumentException("Pengajuan tidak ditemukan.");

            String statusLama = p.getStatusPengajuan();
            
            var adminRef = em.getReference(model.Admin.class, nikAdminYgMemproses);
            p.setAdmin(adminRef);
            p.setStatusPengajuan(s);
            em.merge(p);

            if (!"DITERIMA".equalsIgnoreCase(statusLama) && "DITERIMA".equalsIgnoreCase(s)) {
                Integer nikPengguna = p.getPengguna().getNik();

                var pengguna = em.find(
                    model.Pengguna.class, nikPengguna,
                    jakarta.persistence.LockModeType.PESSIMISTIC_WRITE
                );
                if (pengguna == null) {
                    throw new IllegalStateException("Data Pengguna belum dibuat untuk NIK: " + nikPengguna);
                }

                Integer saldo = pengguna.getSaldoAkun();
                if (saldo == null) saldo = 0;
                pengguna.setSaldoAkun(saldo + NOMINAL_SALDO);
                em.merge(pengguna);
            }

            if ("DITERIMA".equalsIgnoreCase(statusLama) && !"DITERIMA".equalsIgnoreCase(s)) {
                throw new IllegalStateException("Status sudah DITERIMA dan tidak boleh diubah.");
            }

            return null;
        });
    }

    public void ubahStatus(Integer idPengajuan, String statusBaru, Integer nikAdmin) {
        setStatus(idPengajuan, statusBaru, nikAdmin);
    }

    public void prosesPengajuan(int idPengajuan, int nikAdmin, String status) {
        setStatus(idPengajuan, status, nikAdmin);
    }

    public boolean hasPendingByNik(Integer nik) {
        var em = JPAProvider.em();
        try {
            Long c = em.createQuery(
                "SELECT COUNT(p) FROM PengajuanBantuan p " +
                "WHERE p.pengguna.nik = :nik AND p.statusPengajuan = 'MENUNGGU'",
                Long.class
            ).setParameter("nik", nik)
             .getSingleResult();
            return c != null && c > 0;
        } finally {
            em.close();
        }
    }

    public void batalkanPengajuan(Integer idPengajuan, Integer nikPengguna) {
        tx(em -> {
            var p = em.find(PengajuanBantuan.class, idPengajuan);
            if (p == null) 
                throw new IllegalArgumentException("Pengajuan tidak ditemukan.");
            if (!p.getPengguna().getNik().equals(nikPengguna))
                throw new SecurityException("Tidak boleh membatalkan pengajuan milik orang lain.");
            if (!"MENUNGGU".equalsIgnoreCase(p.getStatusPengajuan()))
                throw new IllegalStateException("Hanya pengajuan MENUNGGU yang bisa dibatalkan.");

            em.remove(p);
            return null;
        });
    }
}
>>>>>>> ffcfc0a90936944d338d2b3556aca9c95790d299
