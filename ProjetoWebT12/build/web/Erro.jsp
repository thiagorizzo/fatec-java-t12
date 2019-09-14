<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <h1>Erro</h1>
        <% 
            Exception ex = (Exception) request.getAttribute("exception");
        %>
        
        <h3 style="background-color: red; color: white;">
            <%= ex.getMessage() %>
            <%= ex.toString() %>
        </h3>
    </body>
</html>
