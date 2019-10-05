package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Usuario;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("exception", ex);

            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            HttpSession session = request.getSession();
            
            Usuario usuario = new Usuario();
            usuario.setNome(request.getParameter("nome"));
            
            session.setAttribute("usuarioAutenticado", usuario);
            
            response.sendRedirect("/ProjetoWebT12/Produtos");
        } catch (Exception ex) {
            request.setAttribute("exception", ex);

            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }        
    }
}
