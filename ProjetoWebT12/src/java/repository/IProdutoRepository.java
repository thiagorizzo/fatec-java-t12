 package repository;

import java.util.ArrayList;
import java.util.Optional;
import models.Produto;

public interface IProdutoRepository {
    public Optional<Produto> getByCodigo(int codigo);
    public ArrayList<Produto> getAll();
}
