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
import models.Produto;

public class ProdutoDatabaseRepository implements IProdutoRepository {

    private ArrayList<Produto> produtos;
    private Connection connection;
    
    protected EntityManager entityManager;
    
    public Produto getByCodigo(int codigo) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWebT12PU");
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        
        return entityManager.find(Produto.class, codigo);
    }
    
    public void remove(Produto produto) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWebT12PU");
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        
        entityManager.remove(produto);
    }

    public List<Produto> getAll() throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWebT12PU");
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        return entityManager.createQuery(" FROM " + Produto.class.getName(), Produto.class).getResultList();
    }
}
