package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarCarrinhoServlet", urlPatterns = {"/ListarCarrinho"})
public class ListarCarrinhoServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            RequestDispatcher rd = request.getRequestDispatcher("Carrinho.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("exception", ex);

            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }
}
