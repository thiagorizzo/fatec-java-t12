package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "Listar Produtos",
        urlPatterns = "/Produtos"
)
public class ListarProdutosServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURI();
        try {
            
            PrintWriter pw = response.getWriter();
            pw.print("<html><head></head><body>" + url + "</body></html>");
            
        } catch (IOException ex) {
            Logger.getLogger(ListarProdutosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
