package service;

import App.JPAProvider;
import jakarta.persistence.EntityManager;
import model.Pengguna;

public class PenggunaService {
    public Pengguna temukan(Integer nik) {
        EntityManager em = JPAProvider.em();
        try { 
            return em.find(Pengguna.class, nik); }
        finally { em.close(); }
    }
    
}