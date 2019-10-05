package repository;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import models.Produto;
import models.Usuario;

public class UsuarioRepository {

    public Usuario getByName(String nome) throws SQLException {
        EntityManager em = Repository.getEntityManager();
        Query query = em.createQuery(" FROM " + Usuario.class.getName() + " WHERE nome = :nome", Usuario.class);
        query.setParameter("nome", nome);
        return (Usuario) query.getSingleResult();
    }
}
