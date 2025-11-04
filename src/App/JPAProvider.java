<<<<<<< HEAD
package App;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JPAProvider {

    private static volatile EntityManagerFactory EMF;

    private JPAProvider() { }

    public static EntityManagerFactory getFactory() {
        if (EMF == null) {
            synchronized (JPAProvider.class) {
                if (EMF == null) {
                    EMF = Persistence.createEntityManagerFactory("fincarePU");
                }
            }
        }
        return EMF;
    }

    public static EntityManager em() {
        return getFactory().createEntityManager();
    }

    public static void shutdown() {
        if (EMF != null && EMF.isOpen()) {
            try { EMF.close(); 
            } 
            catch (Exception ignored) {
            }
        }
    }
}
=======
package App;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JPAProvider {

    private static volatile EntityManagerFactory EMF;

    private JPAProvider() { }

    public static EntityManagerFactory getFactory() {
        if (EMF == null) {
            synchronized (JPAProvider.class) {
                if (EMF == null) {
                    EMF = Persistence.createEntityManagerFactory("fincarePU");
                }
            }
        }
        return EMF;
    }

    public static EntityManager em() {
        return getFactory().createEntityManager();
    }

    public static void shutdown() {
        if (EMF != null && EMF.isOpen()) {
            try { EMF.close(); 
            } 
            catch (Exception ignored) {
            }
        }
    }
}
>>>>>>> ffcfc0a90936944d338d2b3556aca9c95790d299
