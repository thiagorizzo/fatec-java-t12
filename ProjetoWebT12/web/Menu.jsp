<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/ProjetoWebT12/Produtos">Produtos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ProjetoWebT12/ListarCarrinho">Carrinho</a>
        </li>  
    </ul>
    ${usuarioAutenticado.getNome()}
</nav>

