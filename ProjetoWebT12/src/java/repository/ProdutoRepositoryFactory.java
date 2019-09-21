package repository;

import enums.*;
import java.sql.SQLException;

public class ProdutoRepositoryFactory {

    public static IProdutoRepository create(ProdutoRepositoryTypeEnum tipo, RepositoryOptions options) throws ClassNotFoundException, SQLException {
        switch(tipo)
        {
            case Database:
                return new ProdutoDatabaseRepository(options.getDatabaseDriver(), options.getDatabaseConnectionString(), options.getDatabaseUserName(), options.getDatabaseUserPassword());
                
            case InMemory:
                return new ProdutoInMemoryRepository();
        }
        
        return null;
    }
}
