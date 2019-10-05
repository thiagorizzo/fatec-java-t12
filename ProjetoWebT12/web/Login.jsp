<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="login" method="POST" action="/ProjetoWebT12/Login">
            <div class="form-group">
                <label>Nome</label>
                <input class="form-control" type="text" name="nome"/>
            </div>
            <div class="form-group">
                <label>Senha</label>
                <input class="form-control" type="password" name="senha"/>
            </div>  
            <button class="btn btn-primary" type="submit">Logar</button>
        </form>
    </body>
</html>
