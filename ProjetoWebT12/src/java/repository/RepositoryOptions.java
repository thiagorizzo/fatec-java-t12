package repository;

public class RepositoryOptions {
    private String databaseDriver;
    private String databaseConnectionString;
    private String databaseUserName;
    private String databaseUserPassword;

    public String getDatabaseDriver() {
        return databaseDriver;
    }

    public void setDatabaseDriver(String databaseDriver) {
        this.databaseDriver = databaseDriver;
    }

    public String getDatabaseConnectionString() {
        return databaseConnectionString;
    }

    public void setDatabaseConnectionString(String databaseConnectionString) {
        this.databaseConnectionString = databaseConnectionString;
    }

    public String getDatabaseUserName() {
        return databaseUserName;
    }

    public void setDatabaseUserName(String databaseUserName) {
        this.databaseUserName = databaseUserName;
    }

    public String getDatabaseUserPassword() {
        return databaseUserPassword;
    }

    public void setDatabaseUserPassword(String databaseUserPassword) {
        this.databaseUserPassword = databaseUserPassword;
    }

    
    
}
