
<%@page import="java.util.List"%>
<%@page import="models.Categoria"%>
<%@page import="models.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<% 
    Produto produto = (Produto) request.getAttribute("produto");
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário Produto</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>        
    </head>
    <body>
        <form method="POST" action="/ProjetoWebT12/EditarProduto">
            <div class="form-group">
                <label>Nome</label>
                <input class="form-control" type="text" name="nome" value="<%= produto.getNome() %>"/>
            </div>
            <div class="form-group">
                <label>Preço</label>
                <input class="form-control" type="number" name="preco" value="<%= produto.getValor()%>"/>
            </div>            
            <div class="form-group">
                <label>Categoria</label>
                <select name="categoria">
                    <% for(Categoria c : categorias) { 
                        boolean isSelected = c.getCodigo() == produto.getCategoria().getCodigo();
                    %>
                        <option value="<%= c.getCodigo() %>" <%= isSelected ? "selected" : "" %> ><%= c.getNome()  %></option>
                    <% } %>
                </select>
            </div>   
            <input type="hidden" name="codigo" value="<%= produto.getCodigo()%>">
            <button class="btn btn-primary" type="submit">Enviar</button>
        </form>
    </body>
</html>
