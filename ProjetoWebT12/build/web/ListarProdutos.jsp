<%-- 
    Document   : ListarProdutos
    Created on : 14/09/2019, 11:13:53
    Author     : FATECRP
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>        
    </head>
    <body>
        <table class="table table-striped">
            <thead>
                <th>Código</th>
                <th>Nome</th>
                <th>Valor</th>
                <th>Categoria</th>
            </thead>
            
            <tbody>
                <%
                    ArrayList<Produto> produtos = (ArrayList<Produto>) request.getAttribute("ListaProdutos");

                    for(Produto produto : produtos) {
                %>
                    <tr>
                        <td><%= produto.getCodigo() %></td>
                        <td><%= produto.getNome() %></td>
                        <td><%= produto.getValor()%></td>
                        <td><%= produto.getCategoria().getNome() %></td>
                        <td><a class="btn btn-primary" href="/ProjetoWebT12/AdicionarCarrinho?codigo=<%= produto.getCodigo() %>">Adicionar</a></td>
                        <td><a class="btn btn-warning" href="/ProjetoWebT12/EditarProduto?codigo=<%= produto.getCodigo() %>">Adicionar</a></td>
                        <td><button class="btn btn-danger" onClick="RemoverProduto(<%= produto.getCodigo() %>)">Remover</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
