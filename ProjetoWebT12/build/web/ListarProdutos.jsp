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
    </head>
    <body>
        <table>
            <thead>
                <th>Código</th>
                <th>Nome</th>
                <th>Valor</th>
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
                    </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
