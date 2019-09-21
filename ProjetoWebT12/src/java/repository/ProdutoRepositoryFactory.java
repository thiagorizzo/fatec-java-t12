package repository;

import enums.*;

public class ProdutoRepositoryFactory {
    public static IProdutoRepository create(ProdutoRepositoryTypeEnum tipo) {
        switch(tipo)
        {
            case Database:
                return new ProdutoDatabaseRepository();
                
            case InMemory:
                return new ProdutoInMemoryRepository();
        }
        
        return null;
    }
}
