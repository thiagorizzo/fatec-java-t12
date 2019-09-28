/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import enums.ProdutoRepositoryTypeEnum;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categoria;
import models.Produto;
import repository.CategoriaDatabaseRepository;
import repository.ICategoriaRepository;
import repository.IProdutoRepository;
import repository.ProdutoRepositoryFactory;

@WebServlet(name = "EditarProduto", urlPatterns = {"/EditarProduto"})
public class EditarProduto extends HttpServlet {
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigoProduto = Integer.parseInt(request.getParameter("codigo"));
        
        IProdutoRepository produtoRepository;
        ICategoriaRepository categoriaRepository;
        try {
            produtoRepository = ProdutoRepositoryFactory.create(ProdutoRepositoryTypeEnum.Database);
            categoriaRepository = new CategoriaDatabaseRepository();
            
            Produto produto = produtoRepository.getByCodigo(codigoProduto);
            List<Categoria> categorias = categoriaRepository.getAll();
            
            request.setAttribute("produto", produto);
            request.setAttribute("categorias", categorias);
            
            RequestDispatcher rd = request.getRequestDispatcher("FormProduto.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("exception", ex);

            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigoProduto = Integer.parseInt(request.getParameter("codigo"));
        String nomeProduto = request.getParameter("nome");
        float precoProduto = Float.parseFloat(request.getParameter("preco"));
        int codigoCategoria = Integer.parseInt(request.getParameter("categoria"));
        
        ICategoriaRepository categoriaRepository;
        IProdutoRepository produtoRepository;
        try {
            produtoRepository = ProdutoRepositoryFactory.create(ProdutoRepositoryTypeEnum.Database);
            categoriaRepository = new CategoriaDatabaseRepository();
            Categoria categoriaProduto = categoriaRepository.getByCodigo(codigoCategoria);

            Produto produto = produtoRepository.getByCodigo(codigoProduto);
            produto.setNome(nomeProduto);
            produto.setValor(precoProduto);
            produto.setCategoria(categoriaProduto);
            
            produtoRepository.update(produto);
        } catch (Exception ex) {
            request.setAttribute("exception", ex);

            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }     
}
