package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Repository {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWebT12PU");
    
    public static EntityManager entityManager;
    
    private Repository() { }
    
    public static EntityManager getEntityManager()
    {
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        
        return entityManager;
    }
    
    public static void update() 
    {
        EntityTransaction et = entityManager.getTransaction();
        et.begin();
        entityManager.flush();
    }
}
