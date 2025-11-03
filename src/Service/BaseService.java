package service;

import App.JPAProvider;
import jakarta.persistence.EntityManager;

public abstract class BaseService {

    protected <R> R tx(FunctionWithEM<R> work) {
        EntityManager em = JPAProvider.em();
        try {
            em.getTransaction().begin();
            R out = work.apply(em);
            em.getTransaction().commit();
            return out;
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    @FunctionalInterface
    protected interface FunctionWithEM<R> {
        R apply(EntityManager em);
    }
}