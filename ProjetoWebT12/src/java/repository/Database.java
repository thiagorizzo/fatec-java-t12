package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton
public class Database {

    private static Database instance;
    private static Connection connection;
    
    private Database(String driver, String stringConnection) throws ClassNotFoundException, SQLException {
        // colocar driver na memória
        Class.forName(driver);
    }
    
    public static Connection getConnection(String driver, String stringConnection) throws ClassNotFoundException, SQLException {
        Database.getInstance(driver, stringConnection);
        if (connection == null)
            connection = DriverManager.getConnection(stringConnection);

        return connection;
    }
  
    public static Database getInstance(String driver, String stringConnection) throws ClassNotFoundException, SQLException {
        if (instance == null)
            instance = new Database(driver, stringConnection);
        
        return instance;
    }
}
