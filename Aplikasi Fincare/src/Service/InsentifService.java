<<<<<<< HEAD
package service;

import App.JPAProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Insentif;
import model.SertifikatPelatihan;

import java.util.List;
import model.InsentifBaris;

public class InsentifService extends BaseService implements CrudService<Insentif, Integer> {

    @Override
    public Insentif tambah(Insentif t) {
        return tx(em -> { em.persist(t); 
        return t; });
    }

    @Override
    public Insentif temukan(Integer id) {
        EntityManager em = JPAProvider.em();
        try { 
            return em.find(Insentif.class, id); }
        finally { em.close(); }
    }

    @Override
    public List<Insentif> temukanSemua() {
        EntityManager em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT i FROM Insentif i ORDER BY i.idInsentif",
                Insentif.class)
                .getResultList();
        } finally { em.close(); }
    }

    @Override
    public Insentif perbarui(Insentif t) {
        return tx(em -> em.merge(t));
    }

    @Override
    public boolean hapus(Integer id) {
        return tx(em -> {
            Insentif x = em.find(Insentif.class, id);
            if (x != null) { 
                em.remove(x); 
                return true;
            }
            return false;
        });
    }

    public List<InsentifBaris> cariTampilan(String keyword) {
        String k = (keyword == null ? "" : keyword.trim().toLowerCase());
        EntityManager em = JPAProvider.em();
        try {
            String jpql =
                "SELECT new model.InsentifBaris(" +
                "  i.idInsentif, s.idSertifikat, a.nik, a.nama, " +
                "  i.jumlahInsentif, i.tanggalCair, i.keterangan" +
                ") " +
                "FROM Insentif i " +
                "JOIN i.sertifikat s " +
                "JOIN s.pengguna a " +
                (k.isEmpty() ? "" :
                 "WHERE (" +
                 "  LOWER(a.nama) LIKE :k OR " +
                 "  CONCAT('', a.nik) LIKE :k OR " +
                 "  CONCAT('', s.idSertifikat) LIKE :k OR " + 
                 "  LOWER(COALESCE(i.keterangan, '')) LIKE :k OR " +
                 "  CONCAT('', i.jumlahInsentif) LIKE :k OR " +
                 "  FUNCTION('DATE_FORMAT', i.tanggalCair, '%Y-%m-%d') LIKE :k" +
                 ") ") +
                "ORDER BY i.idInsentif";

            TypedQuery<InsentifBaris> q = em.createQuery(jpql, InsentifBaris.class);
            if (!k.isEmpty()) q.setParameter("k", "%" + k + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Insentif buatDariSertifikat(int idSertifikat, int nominal) {
        return tx(em -> {
            SertifikatPelatihan s = em.find(SertifikatPelatihan.class, idSertifikat);
            if (s == null) 
                throw new IllegalArgumentException("Sertifikat tidak ditemukan.");
            if (!"DITERIMA".equalsIgnoreCase(s.getStatusSertifikat())) {
                throw new IllegalStateException("Sertifikat belum berstatus DITERIMA.");
            }

            Long sudahAda = em.createQuery(
                "SELECT COUNT(i) FROM Insentif i WHERE i.sertifikat.idSertifikat = :id",
                Long.class
            ).setParameter("id", idSertifikat).getSingleResult();

            if (sudahAda != 0L) {
                return em.createQuery(
                    "SELECT i FROM Insentif i WHERE i.sertifikat.idSertifikat = :id",
                    Insentif.class
                ).setParameter("id", idSertifikat).getSingleResult();
            }

            Insentif i = new Insentif();
            i.setSertifikat(s);
            i.setJumlahInsentif(nominal);
            i.setTanggalCair(null);
            i.setKeterangan("Insentif otomatis karena sertifikat DITERIMA");
            em.persist(i);
            return i;
        });
    }

    public List<Object[]> getInsentifPengguna(int nik) {
        var em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT i.idInsentif, i.jumlahInsentif, i.tanggalCair, i.keterangan " +
                "FROM Insentif i " +
                "JOIN i.sertifikat s " +
                "JOIN s.pengguna a " + 
                "WHERE a.nik = :nik " +
                "ORDER BY i.idInsentif",
                Object[].class
            )
            .setParameter("nik", nik)
            .getResultList();
        } finally {
            em.close();
        }
    }

    public void cairkanLangsung(int idInsentif) {
        tx(em -> {
            var ins = em.find(model.Insentif.class, idInsentif);
            if (ins == null) 
                throw new IllegalStateException("Insentif tidak ditemukan.");
            if (ins.getJumlahInsentif() == null || ins.getJumlahInsentif() <= 0)
                throw new IllegalStateException("Tidak ada insentif untuk dicairkan.");

            ins.setJumlahInsentif(0);
            ins.setTanggalCair(java.time.LocalDate.now());
            ins.setKeterangan("Sudah dicairkan");
            em.merge(ins);
            return null;
        });
    }

}
=======
package service;

import App.JPAProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Insentif;
import model.SertifikatPelatihan;

import java.util.List;
import model.InsentifBaris;

public class InsentifService extends BaseService implements CrudService<Insentif, Integer> {

    @Override
    public Insentif tambah(Insentif t) {
        return tx(em -> { em.persist(t); 
        return t; });
    }

    @Override
    public Insentif temukan(Integer id) {
        EntityManager em = JPAProvider.em();
        try { 
            return em.find(Insentif.class, id); }
        finally { em.close(); }
    }

    @Override
    public List<Insentif> temukanSemua() {
        EntityManager em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT i FROM Insentif i ORDER BY i.idInsentif",
                Insentif.class)
                .getResultList();
        } finally { em.close(); }
    }

    @Override
    public Insentif perbarui(Insentif t) {
        return tx(em -> em.merge(t));
    }

    @Override
    public boolean hapus(Integer id) {
        return tx(em -> {
            Insentif x = em.find(Insentif.class, id);
            if (x != null) { 
                em.remove(x); 
                return true;
            }
            return false;
        });
    }

    public List<InsentifBaris> cariTampilan(String keyword) {
        String k = (keyword == null ? "" : keyword.trim().toLowerCase());
        EntityManager em = JPAProvider.em();
        try {
            String jpql =
                "SELECT new model.InsentifBaris(" +
                "  i.idInsentif, s.idSertifikat, a.nik, a.nama, " +
                "  i.jumlahInsentif, i.tanggalCair, i.keterangan" +
                ") " +
                "FROM Insentif i " +
                "JOIN i.sertifikat s " +
                "JOIN s.pengguna a " +
                (k.isEmpty() ? "" :
                 "WHERE (" +
                 "  LOWER(a.nama) LIKE :k OR " +
                 "  CONCAT('', a.nik) LIKE :k OR " +
                 "  CONCAT('', s.idSertifikat) LIKE :k OR " + 
                 "  LOWER(COALESCE(i.keterangan, '')) LIKE :k OR " +
                 "  CONCAT('', i.jumlahInsentif) LIKE :k OR " +
                 "  FUNCTION('DATE_FORMAT', i.tanggalCair, '%Y-%m-%d') LIKE :k" +
                 ") ") +
                "ORDER BY i.idInsentif";

            TypedQuery<InsentifBaris> q = em.createQuery(jpql, InsentifBaris.class);
            if (!k.isEmpty()) q.setParameter("k", "%" + k + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Insentif buatDariSertifikat(int idSertifikat, int nominal) {
        return tx(em -> {
            SertifikatPelatihan s = em.find(SertifikatPelatihan.class, idSertifikat);
            if (s == null) 
                throw new IllegalArgumentException("Sertifikat tidak ditemukan.");
            if (!"DITERIMA".equalsIgnoreCase(s.getStatusSertifikat())) {
                throw new IllegalStateException("Sertifikat belum berstatus DITERIMA.");
            }

            Long sudahAda = em.createQuery(
                "SELECT COUNT(i) FROM Insentif i WHERE i.sertifikat.idSertifikat = :id",
                Long.class
            ).setParameter("id", idSertifikat).getSingleResult();

            if (sudahAda != 0L) {
                return em.createQuery(
                    "SELECT i FROM Insentif i WHERE i.sertifikat.idSertifikat = :id",
                    Insentif.class
                ).setParameter("id", idSertifikat).getSingleResult();
            }

            Insentif i = new Insentif();
            i.setSertifikat(s);
            i.setJumlahInsentif(nominal);
            i.setTanggalCair(null);
            i.setKeterangan("Insentif otomatis karena sertifikat DITERIMA");
            em.persist(i);
            return i;
        });
    }

    public List<Object[]> getInsentifPengguna(int nik) {
        var em = JPAProvider.em();
        try {
            return em.createQuery(
                "SELECT i.idInsentif, i.jumlahInsentif, i.tanggalCair, i.keterangan " +
                "FROM Insentif i " +
                "JOIN i.sertifikat s " +
                "JOIN s.pengguna a " + 
                "WHERE a.nik = :nik " +
                "ORDER BY i.idInsentif",
                Object[].class
            )
            .setParameter("nik", nik)
            .getResultList();
        } finally {
            em.close();
        }
    }

    public void cairkanLangsung(int idInsentif) {
        tx(em -> {
            var ins = em.find(model.Insentif.class, idInsentif);
            if (ins == null) 
                throw new IllegalStateException("Insentif tidak ditemukan.");
            if (ins.getJumlahInsentif() == null || ins.getJumlahInsentif() <= 0)
                throw new IllegalStateException("Tidak ada insentif untuk dicairkan.");

            ins.setJumlahInsentif(0);
            ins.setTanggalCair(java.time.LocalDate.now());
            ins.setKeterangan("Sudah dicairkan");
            em.merge(ins);
            return null;
        });
    }

}
>>>>>>> ffcfc0a90936944d338d2b3556aca9c95790d299
