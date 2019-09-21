/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.RepositoryOptions;

public abstract class BaseServlet extends HttpServlet {

    protected RepositoryOptions repositoryOptions;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        String databaseConnectionString = config.getServletContext().getInitParameter("databaseConnectionString");
        String databaseDriver = config.getServletContext().getInitParameter("databaseDriver");
        String databaseUserName = config.getServletContext().getInitParameter("databaseUserName");
        String databaseUserPassword = config.getServletContext().getInitParameter("databaseUserPassword");
        
        repositoryOptions = new RepositoryOptions();
        repositoryOptions.setDatabaseDriver(databaseDriver);
        repositoryOptions.setDatabaseConnectionString(databaseConnectionString);
        repositoryOptions.setDatabaseUserName(databaseUserName);
        repositoryOptions.setDatabaseUserPassword(databaseUserPassword);        
    }    
}
