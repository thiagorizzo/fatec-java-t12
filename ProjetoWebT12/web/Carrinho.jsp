<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
    </head>
    <body>
        
        <core:forEach items="${carrinho.getProdutos()}" var="produtoCarrinho">
            ${produtoCarrinho.getProduto().getNome()}
        </core:forEach>
    </body>
</html>
