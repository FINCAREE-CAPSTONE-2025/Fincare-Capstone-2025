package service;

import App.JPAProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import java.time.LocalDateTime;
import model.Pelatihan;

import java.util.List;
import model.Akun;
import model.PelatihanPengguna;
import model.Pengguna;

public class PelatihanService extends BaseService implements CrudService<Pelatihan, Integer> {

    @Override
    public Pelatihan tambah(Pelatihan t) {
        return tx(em -> {
            if (t.getNikAdmin() == null)
                throw new IllegalArgumentException("Sesi admin tidak valid (nik_admin kosong).");
            em.persist(t);
            return t;
        });
    }

    @Override
    public Pelatihan temukan(Integer id) {
        EntityManager em = JPAProvider.em();
        try { 
            return em.find(Pelatihan.class, id); }
        finally { em.close(); }
    }

    @Override
    public List<Pelatihan> temukanSemua() {
        EntityManager em = JPAProvider.em();
        try {
            return em.createQuery(
                    "SELECT p FROM Pelatihan p ORDER BY p.idPelatihan", Pelatihan.class)
                    .getResultList();
        } finally { em.close(); }
    }

    @Override
    public Pelatihan perbarui(Pelatihan t) {
        return tx(em -> {
            Pelatihan db = em.find(Pelatihan.class, t.getIdPelatihan());
            if (db == null) 
                throw new IllegalArgumentException("Data pelatihan tidak ditemukan.");

            db.setJudul(t.getJudul());
            db.setLembaga(t.getLembaga());
            db.setPeriode(t.getPeriode());
            db.setHarga(t.getHarga());

            return db;
        });
    }

    @Override
    public boolean hapus(Integer id) {
        return tx(em -> {
            Pelatihan x = em.find(Pelatihan.class, id);
            if (x != null) {
                em.remove(x); 
                return true; 
            }
            return false;
        });
    }

    public List<Pelatihan> cari(String keyword) {
        EntityManager em = JPAProvider.em();
        try {
            String k = "%" + keyword.toLowerCase() + "%";
            return em.createQuery(
                    "SELECT p FROM Pelatihan p " +
                    "WHERE LOWER(p.judul)   LIKE :k " +
                    "   OR LOWER(p.lembaga) LIKE :k " +
                    "   OR LOWER(p.periode) LIKE :k " +
                    "ORDER BY p.idPelatihan", Pelatihan.class)
                    .setParameter("k", k)
                    .getResultList();
        } finally { em.close(); }
    }
    
    public void beliPelatihan(int nik, int idPelatihan) {
        tx(em -> {
            Akun akun = em.find(Akun.class, nik);
            Pelatihan pel = em.find(Pelatihan.class, idPelatihan);

            if (akun == null || pel == null) 
                throw new IllegalStateException("Data tidak lengkap.");

            Long sudahBeli = em.createQuery(
                "SELECT COUNT(pp) FROM PelatihanPengguna pp " +
                "WHERE pp.pengguna.nik = :nik AND pp.pelatihan.idPelatihan = :idPelatihan",
                Long.class
            )
            .setParameter("nik", nik)
            .setParameter("idPelatihan", idPelatihan)
            .getSingleResult();

            if (sudahBeli != null && sudahBeli > 0)
                throw new IllegalStateException("Pelatihan ini sudah pernah kamu beli.");

            Pengguna p = em.find(Pengguna.class, nik, LockModeType.PESSIMISTIC_WRITE);
            int saldo = p.getSaldoAkun() == null ? 0 : p.getSaldoAkun();
            int harga = pel.getHarga();

            if (saldo < harga)
                throw new IllegalStateException("Saldo tidak cukup untuk membeli pelatihan ini.");

            p.setSaldoAkun(saldo - harga);
            em.merge(p);

            PelatihanPengguna pp = new PelatihanPengguna();
            pp.setPengguna(akun);
            pp.setPelatihan(pel);
            pp.setTanggalBeli(LocalDateTime.now());
            em.persist(pp);

            return null;
        });
    }

    public boolean bolehBeliPelatihan(int nik) {
        return tx(em -> {
            var list = em.createQuery(
                "SELECT p.statusPengajuan FROM PengajuanBantuan p " +
                "WHERE p.pengguna.nik = :nik " +
                "ORDER BY p.tanggalPengajuan",
                String.class
            )
            .setParameter("nik", nik)
            .setMaxResults(1)
            .getResultList();

            if (list.isEmpty()) return false;
            return "DITERIMA".equalsIgnoreCase(list.get(0));
        });
    }
    
    public List<Object[]> getRiwayatPelatihanDariNik(int nik) {
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

    public boolean sudahPernahBeli(int nik, int idPelatihan) {
        var em = JPAProvider.em();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(pp) FROM PelatihanPengguna pp " +
                "WHERE pp.pengguna.nik = :nik AND pp.pelatihan.idPelatihan = :idPel",
                Long.class
            )
            .setParameter("nik", nik)
            .setParameter("idPel", idPelatihan)
            .getSingleResult();

            return count != null && count > 0;
        } finally {
            em.close();
        }
    }


}
