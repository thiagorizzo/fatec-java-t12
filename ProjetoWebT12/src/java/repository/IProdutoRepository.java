 package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import models.Produto;

public interface IProdutoRepository {
    public Optional<Produto> getByCodigo(int codigo)  throws Exception ;
    public ArrayList<Produto> getAll() throws Exception ;
}
