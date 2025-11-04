package service;

import App.JPAProvider;
import jakarta.persistence.EntityManager;
import java.util.List;
import model.Akun;

import model.SertifikatPelatihan;
import model.Insentif;
import model.Pelatihan;

public class SertifikatService extends BaseService implements CrudService<SertifikatPelatihan, Integer> {

    @Override
    public SertifikatPelatihan tambah(SertifikatPelatihan t) {
        return tx(em -> { 
            em.persist(t); 
            return t; 
        });
    }

    @Override
    public SertifikatPelatihan temukan(Integer id) {
        EntityManager em = JPAProvider.em();
        try { 
            return em.find(SertifikatPelatihan.class, id); 
        }
        finally { em.close(); }
    }

    @Override
    public List<SertifikatPelatihan> temukanSemua() {
        EntityManager em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT s FROM SertifikatPelatihan s ORDER BY s.idSertifikat",
                SertifikatPelatihan.class
            ).getResultList();
        } finally { em.close(); }
    }

    @Override
    public SertifikatPelatihan perbarui(SertifikatPelatihan t) {
        return tx(em -> em.merge(t));
    }

    @Override
    public boolean hapus(Integer id) {
        return tx(em -> {
            SertifikatPelatihan x = em.find(SertifikatPelatihan.class, id);
            if (x != null) {
                em.remove(x); 
                return true; 
            }
            return false;
        });
    }
    
    // admin
    public List<Object[]> cariUntukVerifikasi(String q) {
        String k = (q == null ? "" : q.trim().toLowerCase());
        var em = JPAProvider.em();
        try {
            String jpql =
                "SELECT s.idSertifikat, " +
                "       a.nik, " + 
                "       COALESCE(a.nama, ''), " +
                "       p.idPelatihan, " + 
                "       COALESCE(s.statusSertifikat,''), " +
                "       s.linkSertifikat, " +
                "       s.tanggalUpload " +
                "FROM SertifikatPelatihan s " +
                "JOIN s.pengguna a " +
                "LEFT JOIN s.pelatihan p " +
                (k.isEmpty() ? "" :
                 "WHERE LOWER(COALESCE(a.nama,'')) LIKE :k " +
                 "   OR LOWER(COALESCE(s.statusSertifikat,'')) LIKE :k ") +
                "ORDER BY s.idSertifikat";

            var qy = em.createQuery(jpql, Object[].class);
            if (!k.isEmpty()) qy.setParameter("k", "%" + k + "%");
            return qy.getResultList();
        } finally {
            em.close();
        }
    }

    public void verifikasi(int idSertifikat, boolean diterima, String linkSertifikat) {
        tx(em -> {
            SertifikatPelatihan s = em.find(SertifikatPelatihan.class, idSertifikat);
            if (s == null) 
                throw new IllegalArgumentException("Sertifikat tidak ditemukan.");

            if ("DITERIMA".equalsIgnoreCase(s.getStatusSertifikat())) {
                throw new IllegalStateException("Status sudah DITERIMA dan tidak dapat diubah.");
            }

            if (linkSertifikat != null && !linkSertifikat.isBlank()) {
                s.setLinkSertifikat(linkSertifikat.trim());
            }

            if (diterima) {
                s.setStatusSertifikat("DITERIMA");

                Long ada = em.createQuery(
                    "SELECT COUNT(i) FROM Insentif i WHERE i.sertifikat.idSertifikat = :id",
                    Long.class
                ).setParameter("id", idSertifikat).getSingleResult();

                if (ada == 0L) {
                    Insentif i = new Insentif();
                    i.setSertifikat(s);
                    i.setJumlahInsentif(3_500_000);
                    i.setTanggalCair(null);
                    i.setKeterangan("Insentif otomatis karena sertifikat DITERIMA");
                    em.persist(i);
                }
            } else {
                s.setStatusSertifikat("DITOLAK");
            }

            em.merge(s);
            return null;
        });
    }
    
    // pengguna
    public List<Object[]> daftarSertifikatPengguna(int nik) {
        var em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT s.idSertifikat, " +
                "       COALESCE(p.judul, ''), " +
                "       s.linkSertifikat, " +
                "       s.statusSertifikat, " +
                "       s.tanggalUpload " +
                "FROM SertifikatPelatihan s " +
                "LEFT JOIN s.pelatihan p " +
                "WHERE s.pengguna.nik = :nik " +
                "ORDER BY s.idSertifikat", Object[].class
            ).setParameter("nik", nik).getResultList();
        } finally { em.close(); }
    }
    
    // Upload tanpa terkait pelatihan
    public SertifikatPelatihan tambahLinkSertifikat(int nik, String link) {
        return tx(em -> {
            if (hasPendingDariNik(nik))
                throw new IllegalStateException("Masih ada sertifikat MENUNGGU. Tunggu verifikasi selesai.");

            Akun a = em.find(Akun.class, nik);
            if (a == null) throw new IllegalArgumentException("Akun tidak ditemukan.");

            SertifikatPelatihan s = new SertifikatPelatihan();
            s.setPengguna(a);
            s.setPelatihan(null);
            s.setLinkSertifikat(link);
            s.setStatusSertifikat("MENUNGGU");
            s.setTanggalUpload(java.time.LocalDate.now());
            em.persist(s);
            return s;
        });
    }

    // Upload yang TERKAIT pelatihan yang dibeli pengguna
    public SertifikatPelatihan tambahLinkSertifikatDariPelatihan(int nik, int idPelatihan, String link) {
        return tx(em -> {
            if (hasPendingDariNik(nik))
                throw new IllegalStateException("Masih ada sertifikat MENUNGGU. Tunggu verifikasi selesai.");

            Akun a = em.find(Akun.class, nik);
            Pelatihan p = em.find(Pelatihan.class, idPelatihan);
            if (a == null || p == null) throw new IllegalArgumentException("Data tidak lengkap.");

            SertifikatPelatihan s = new SertifikatPelatihan();
            s.setPengguna(a);
            s.setPelatihan(p);
            s.setLinkSertifikat(link);
            s.setStatusSertifikat("MENUNGGU");
            s.setTanggalUpload(java.time.LocalDate.now());
            em.persist(s);
            return s;
        });
    }
    
    public List<Object[]> getRiwayatPelatihanByNik(int nik) {
        var em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT p.idPelatihan, p.judul, p.lembaga, p.periode, p.harga " +
                "FROM PelatihanPengguna pp " +
                "JOIN pp.pelatihan p " +
                "WHERE pp.pengguna.nik = :nik " +
                "ORDER BY pp.tanggalBeli",
                Object[].class
            )
            .setParameter("nik", nik)
            .getResultList();
        } finally { em.close(); }
    }
    
    public void resubmitLinkDitolak(int idSertifikat, String linkBaru) {
        tx(em -> {
            var s = em.find(model.SertifikatPelatihan.class, idSertifikat);
            if (s == null) throw new IllegalArgumentException("Sertifikat tidak ditemukan.");
            if (!"DITOLAK".equalsIgnoreCase(s.getStatusSertifikat())) {
                throw new IllegalStateException("Hanya bisa kirim ulang jika status DITOLAK.");
            }
            if (linkBaru == null || linkBaru.isBlank()) {
                throw new IllegalArgumentException("Link tidak boleh kosong.");
            }

            s.setLinkSertifikat(linkBaru.trim());
            s.setStatusSertifikat("MENUNGGU");
            s.setTanggalUpload(java.time.LocalDate.now());
            em.merge(s);
            return null;
        });
    }


    public void updateLinkSertifikat(int idSertifikat, String linkBaru) {
        tx(em -> {
            SertifikatPelatihan s = em.find(SertifikatPelatihan.class, idSertifikat);
            if (s == null) 
                throw new IllegalArgumentException("Sertifikat tidak ditemukan.");
            if ("DITERIMA".equalsIgnoreCase(s.getStatusSertifikat()))
                throw new IllegalStateException("Sertifikat sudah DITERIMA dan tidak dapat diubah.");

            s.setLinkSertifikat(linkBaru == null ? null : linkBaru.trim());
            em.merge(s);
            return null;
        });
    }
    
    public boolean hasPendingDariNik(int nik) {
        var em = JPAProvider.em();
        try {
            Long c = em.createQuery(
                "SELECT COUNT(s) FROM SertifikatPelatihan s " +
                "WHERE s.pengguna.nik = :nik AND s.statusSertifikat = 'MENUNGGU'",
                Long.class
            ).setParameter("nik", nik).getSingleResult();
            return c != null && c > 0;
        } finally { em.close(); }
    }


}
