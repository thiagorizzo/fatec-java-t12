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
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Produto;
import static repository.Repository.entityManager;

/*
    Novo produto
         - new Produto()
         - persist()
         - commit

    Alterar produto

        1) 
            - find/createQuery (coloca como gerenciado)
            - modifica o objeto
            - commit

        2) Deatached
            - produto com Id (chave primária) porém não está gerenciado
            - merge (entrar no estado gerenciado)
            - commit

    Remover produto

        1)
            - find/query
            - marca objeto como removido
            - commit

        2)
            - produto com ID
            - merge
            - removed
            - commit
*/
public class ProdutoDatabaseRepository implements IProdutoRepository {

    private ArrayList<Produto> produtos;
    private Connection connection;
    
    public Produto getByCodigo(int codigo) throws SQLException {
        EntityManager em = Repository.getEntityManager();
        return em.find(Produto.class, codigo);
    }
    
    public void remove(Produto produto) throws SQLException {
        EntityManager em = Repository.getEntityManager();
        em.remove(produto);
    }

    public List<Produto> getAll() throws SQLException {
        EntityManager em = Repository.getEntityManager();
        return em.createQuery(" FROM " + Produto.class.getName(), Produto.class).getResultList();
    }

    public Produto create(Produto produto) {
        EntityManager em = Repository.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(produto);
        transaction.commit();
        return produto;
    }
    
    @Override
    public void update(Produto produto) throws Exception {
        Repository.update();
    }

    @Override
    public List<Produto> getByNome(String nomeProduto) throws Exception {
        EntityManager em = Repository.getEntityManager();
        TypedQuery<Produto> query = em.createQuery(" FROM " + Produto.class.getName() + " WHERE nome LIKE :nomeProduto", Produto.class);
        query.setParameter("nomeProduto", "%" + nomeProduto + "%");
        return query.getResultList();
    }
}
