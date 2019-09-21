package servlets;

import enums.ProdutoRepositoryTypeEnum;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;
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
import repository.*;

@WebServlet(
        name = "Listar Produtos",
        urlPatterns = "/Produtos"
)
public class ListarProdutosServlet extends HttpServlet {

    private IProdutoRepository produtoRepository = ProdutoRepositoryFactory.create(ProdutoRepositoryTypeEnum.InMemory);
    
    public void init(ServletConfig config) {
        //String connectionString = getServletContext().getInitParameter("connectionString");
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url = request.getRequestURI();
        
        try {
            ArrayList<Produto> produtos = null;
            
            String codigoString = request.getParameter("codigo");
            if (codigoString == null || codigoString.isEmpty())
                produtos = produtoRepository.getAll();
            else {
                produtos = new ArrayList<Produto>();
                Optional<Produto> produto = produtoRepository.getByCodigo(Integer.parseInt(codigoString));
                if (produto.isPresent())
                    produtos.add(produto.get());
            }

            // Incluindo produtos no atributo da requisição
            request.setAttribute("ListaProdutos", produtos);

            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("ListarProdutos.jsp");
            rd.forward(request, response);
            
        } catch (Exception ex) {
            request.setAttribute("exception", ex);

            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }
}
