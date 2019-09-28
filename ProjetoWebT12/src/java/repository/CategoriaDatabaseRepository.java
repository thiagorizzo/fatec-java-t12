package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Categoria;

public class CategoriaDatabaseRepository implements ICategoriaRepository {

    private ArrayList<Categoria> categorias;
    private Connection connection;
    
    protected EntityManager entityManager;
    
    public Categoria getByCodigo(int codigo) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWebT12PU");
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        
        return entityManager.find(Categoria.class, codigo);
    }
    
    public void remove(Categoria categoria) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWebT12PU");
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        
        entityManager.remove(categoria);
    }

    public List<Categoria> getAll() throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWebT12PU");
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        return entityManager.createQuery(" FROM " + Categoria.class.getName(), Categoria.class).getResultList();
    }
}
