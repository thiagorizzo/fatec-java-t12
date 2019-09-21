package repository;

import java.util.ArrayList;
import java.util.Optional;
import models.Produto;

public class ProdutoDatabaseRepository implements IProdutoRepository {

    private ArrayList<Produto> produtos;
    
    public ProdutoDatabaseRepository() {
        produtos = new ArrayList<Produto>();
        produtos.add(new Produto(1, "League of Legends", 0));
        produtos.add(new Produto(2, "World of Warcraft", 259.0f));
        produtos.add(new Produto(3, "Metal Gear", 550.0f));
        produtos.add(new Produto(4, "Zelda", 45.0f));        
    }
    
    @Override
    public Optional<Produto> getByCodigo(int codigo) {
        return produtos.stream().filter(p -> p.getCodigo() == codigo).findFirst();
    }

    @Override
    public ArrayList<Produto> getAll() {
        return produtos;
    }
}
