package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import models.Produto;

public class ProdutoDatabaseRepository implements IProdutoRepository {

    private ArrayList<Produto> produtos;
    private Connection connection;
    
    public ProdutoDatabaseRepository(String driver, String stringConnection, String userName, String userPassword) throws ClassNotFoundException, SQLException {
        connection = Database.getConnection(driver , stringConnection, userName, userPassword);
    }
    
    @Override
    public Optional<Produto> getByCodigo(int codigo) throws SQLException {
        Optional<Produto> produto = null;
        
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM produto WHERE codigo = ?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.first()) {
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            produto = Optional.of(new Produto(codigo, nome, preco));
        }
        
        return produto;
    }

    @Override
    public ArrayList<Produto> getAll() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM produto");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int codigo = rs.getInt("id");
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            Produto produto = new Produto(codigo, nome, preco);
            
            produtos.add(produto);
        }
        
        return produtos;        
    }
}
