<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>        
    </head>
    <body>
        <core:if test="${carrinho != null}">
            <table class="table table-striped">
                <thead>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                    <th>Total</th>
                </thead>
                <tbody>
                    <core:forEach items="${carrinho.getProdutos()}" var="produtoCarrinho">
                        <tr>
                            <td>${produtoCarrinho.getProduto().getNome()}</td>
                            <td>${produtoCarrinho.getQuantidade()}</td>
                            <td><format:formatNumber type="currency" value="${produtoCarrinho.getProduto().getValor()}"/></td>
                            <td><format:formatNumber type="currency" value="${produtoCarrinho.getProduto().getValor() *  produtoCarrinho.getQuantidade()}"/></td>
                            <core:set var="total" value="${total + produtoCarrinho.getProduto().getValor() *  produtoCarrinho.getQuantidade()}"/>
                        </tr>
                    </core:forEach>
                    <tr>
                        <td colspan="3" style="text-align:right;">Total:</td>
                        <td><format:formatNumber type="currency" value="${total}"/></td>
                    </tr>
                </tbody>
            </table>
            <a class="btn btn-danger" href="/ProjetoWebT12/LimparCarrinho">Limpar Carrinho</a>
        </core:if>
        <core:if test="${carrinho == null}">
            <h3>Carrinho vazio.</h3>
        </core:if>
    </body>
</html>
