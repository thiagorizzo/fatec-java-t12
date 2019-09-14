package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Produto;

@WebServlet(
        name = "Listar Produtos",
        urlPatterns = "/Produtos"
)
public class ListarProdutosServlet extends HttpServlet {

    public void init(ServletConfig config) {
        //String connectionString = getServletContext().getInitParameter("connectionString");
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURI();
        
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto(1, "League of Legends", 0));
        produtos.add(new Produto(2, "World of Warcraft", 259.0f));
        produtos.add(new Produto(3, "Metal Gear", 550.0f));
        produtos.add(new Produto(4, "Zelda", 45.0f));
        
        try {
            // Incluindo produtos no atributo da requisição
            request.setAttribute("ListaProdutos", produtos);
            
            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("ListarProdutos.jsp");
            rd.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(ListarProdutosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ListarProdutosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
