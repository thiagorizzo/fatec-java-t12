 package repository;

import java.util.List;
import models.Produto;

public interface IProdutoRepository {
    public Produto getByCodigo(int codigo)  throws Exception ;
    public void update(Produto produto) throws Exception ;
    public List<Produto> getAll() throws Exception ;
}
