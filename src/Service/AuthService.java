<<<<<<< HEAD
package service;

import App.JPAProvider;
import jakarta.persistence.EntityManager;
import model.Akun;

public class AuthService extends BaseService {

    public Akun login(String email, String password) {
        try (EntityManager em = JPAProvider.em()) {
            return em.createQuery(
                "SELECT a FROM Akun a WHERE a.email = :e AND a.password = :p", Akun.class)
                .setParameter("e", email.trim().toLowerCase())
                .setParameter("p", password)
                .getResultStream().findFirst().orElse(null);
        }
    }

    public boolean nikSudahDipakai(Integer nik) {
        try (EntityManager em = App.JPAProvider.em()) {
            Long n = em.createQuery("select count(a) from Akun a where a.nik=:n", Long.class)
                       .setParameter("n", nik)
                       .getSingleResult();
            return n != null && n > 0;
        }
    }
    public Akun registerPengguna(Integer nikInput, String nama, String email, String password, String alamat, String pekerjaan, Integer penghasilan) {
        return tx(em -> {
            Long cEmail = em.createQuery("select count(a) from Akun a where a.email=:e", Long.class)
                            .setParameter("e", email.trim().toLowerCase())
                            .getSingleResult();
            if (cEmail > 0) throw new RuntimeException("Email sudah terdaftar.");

            Akun a = new Akun();
            if (nikInput != null && nikInput > 0) {
                a.setNik(nikInput);
            }
            a.setNama(nama);
            a.setEmail(email.trim().toLowerCase());
            a.setPassword(password);
            a.setPeran("pengguna");
            em.persist(a);
            em.flush();

            // buat pengguna
            model.Pengguna p = new model.Pengguna();
            p.setAkun(a);
            p.setAlamat(alamat);
            p.setPekerjaan(pekerjaan);
            p.setPenghasilan(penghasilan);
            p.setTanggalDaftar(new java.sql.Date(System.currentTimeMillis()));
            p.setSaldoAkun(0);
            em.persist(p);

            return a;
        });
    }

    public boolean emailSudahDipakai(String email) {
        try (EntityManager em = JPAProvider.em()) {
            Long n = em.createQuery(
                "SELECT COUNT(a) FROM Akun a WHERE a.email = :e", Long.class)
                .setParameter("e", email.trim().toLowerCase())
                .getSingleResult();
            return n != null && n > 0;
        }
    }
}
=======
package service;

import App.JPAProvider;
import jakarta.persistence.EntityManager;
import model.Akun;

public class AuthService extends BaseService {

    public Akun login(String email, String password) {
        try (EntityManager em = JPAProvider.em()) {
            return em.createQuery(
                "SELECT a FROM Akun a WHERE a.email = :e AND a.password = :p", Akun.class)
                .setParameter("e", email.trim().toLowerCase())
                .setParameter("p", password)
                .getResultStream().findFirst().orElse(null);
        }
    }

    public boolean nikSudahDipakai(Integer nik) {
        try (EntityManager em = App.JPAProvider.em()) {
            Long n = em.createQuery("select count(a) from Akun a where a.nik=:n", Long.class)
                       .setParameter("n", nik)
                       .getSingleResult();
            return n != null && n > 0;
        }
    }
    public Akun registerPengguna(Integer nikInput, String nama, String email, String password, String alamat, String pekerjaan, Integer penghasilan) {
        return tx(em -> {
            Long cEmail = em.createQuery("select count(a) from Akun a where a.email=:e", Long.class)
                            .setParameter("e", email.trim().toLowerCase())
                            .getSingleResult();
            if (cEmail > 0) throw new RuntimeException("Email sudah terdaftar.");

            Akun a = new Akun();
            if (nikInput != null && nikInput > 0) {
                a.setNik(nikInput);
            }
            a.setNama(nama);
            a.setEmail(email.trim().toLowerCase());
            a.setPassword(password);
            a.setPeran("pengguna");
            em.persist(a);
            em.flush();

            // buat pengguna
            model.Pengguna p = new model.Pengguna();
            p.setAkun(a);
            p.setAlamat(alamat);
            p.setPekerjaan(pekerjaan);
            p.setPenghasilan(penghasilan);
            p.setTanggalDaftar(new java.sql.Date(System.currentTimeMillis()));
            p.setSaldoAkun(0);
            em.persist(p);

            return a;
        });
    }

    public boolean emailSudahDipakai(String email) {
        try (EntityManager em = JPAProvider.em()) {
            Long n = em.createQuery(
                "SELECT COUNT(a) FROM Akun a WHERE a.email = :e", Long.class)
                .setParameter("e", email.trim().toLowerCase())
                .getSingleResult();
            return n != null && n > 0;
        }
    }
}
>>>>>>> ffcfc0a90936944d338d2b3556aca9c95790d299
