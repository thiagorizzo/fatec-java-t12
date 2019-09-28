package repository;

import enums.*;
import java.sql.SQLException;

public class ProdutoRepositoryFactory {

    public static IProdutoRepository create(ProdutoRepositoryTypeEnum tipo) throws ClassNotFoundException, SQLException {
        switch(tipo)
        {
            case Database:
                return new ProdutoDatabaseRepository();
        }
        
        return null;
    }
}
