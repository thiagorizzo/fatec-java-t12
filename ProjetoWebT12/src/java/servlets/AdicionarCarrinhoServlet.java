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
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import repository.IProdutoRepository;
import repository.ProdutoRepositoryFactory;

@WebServlet(
        name = "AdicionarCarrinhoServlet", 
        urlPatterns = {"/AdicionarCarrinho"}
)
public class AdicionarCarrinhoServlet extends BaseServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigoProduto = Integer.parseInt(request.getParameter("codigo"));
        
        HttpSession session = request.getSession();
        
        try {
            IProdutoRepository produtoRepository = ProdutoRepositoryFactory.create(ProdutoRepositoryTypeEnum.Database, repositoryOptions);

            Produto produto = produtoRepository.getByCodigo(codigoProduto);
            if (produto == null)
                throw new Exception("Produto não encontrado.");

            Object carrinhoSessao = (Carrinho) session.getAttribute("carrinho");
            if (carrinhoSessao == null) {
                ArrayList<ProdutoCarrinho> produtos = new ArrayList<ProdutoCarrinho>();
                ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
                produtoCarrinho.setProduto(produto);
                produtoCarrinho.setQuantidade(1);
                produtos.add(produtoCarrinho);
                
                Carrinho carrinho = new Carrinho();
                carrinho.setProdutos(produtos);
                
                session.setAttribute("carrinho", carrinho);
            } else {
                Carrinho carrinho = (Carrinho) carrinhoSessao;
                Optional<ProdutoCarrinho> produtoCarrinho = carrinho.getProdutos().stream().filter(p -> p.getProduto().getCodigo() == codigoProduto).findFirst();
                if (!produtoCarrinho.isPresent()) {
                    ProdutoCarrinho novo = new ProdutoCarrinho();
                    novo.setProduto(produto);
                    novo.setQuantidade(1);
                    
                    carrinho.getProdutos().add(novo);
                    
                    session.setAttribute("carrinho", carrinho);
                } else {
                    carrinho.getProdutos().forEach(p -> {
                        if (p.getProduto().getCodigo() == codigoProduto)
                            p.setQuantidade(p.getQuantidade() + 1);
                    });
                    
                    session.setAttribute("carrinho", carrinho);
                }
            }
        } catch (Exception ex) {
            request.setAttribute("exception", ex);

            // Repassar request e response para JSP
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);            
        }
    }
}
