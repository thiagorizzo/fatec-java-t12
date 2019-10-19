package webservice;

import enums.ProdutoRepositoryTypeEnum;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Categoria;
import models.Produto;
import repository.CategoriaDatabaseRepository;
import repository.ICategoriaRepository;
import repository.IProdutoRepository;
import repository.ProdutoRepositoryFactory;

@Path("/Produto")
public class ProdutoWS {
    
    @GET       
    @Produces(MediaType.APPLICATION_JSON)
    public /*Response*/ List<Produto> GetProdutos(@QueryParam("nome") String nomeProduto) {
        try {
            IProdutoRepository produtoRepository = ProdutoRepositoryFactory.create(ProdutoRepositoryTypeEnum.Database);
            List<Produto> produtos = null;
            if (nomeProduto == null || nomeProduto == "")
                 produtos = produtoRepository.getAll();
            else
                produtos = produtoRepository.getByNome(nomeProduto);
              
            return produtos;
            //return Response.ok().entity(produtos).build();
        } catch (Exception ex) {
            return null;
            //return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GET
    @Path("{codigo}")  
    @Produces(MediaType.APPLICATION_JSON) 
    public Response  GetProduto(@PathParam("codigo") int codigo) {
        try {
            IProdutoRepository produtoRepository = ProdutoRepositoryFactory.create(ProdutoRepositoryTypeEnum.Database);
            Produto produto = produtoRepository.getByCodigo(codigo);
            return Response.ok(produto).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response CreateProduto(Produto produto) {
        try {
            IProdutoRepository produtoRepository = ProdutoRepositoryFactory.create(ProdutoRepositoryTypeEnum.Database);
            ICategoriaRepository categoriaRepository = new CategoriaDatabaseRepository();
            Categoria categoria = categoriaRepository.getByCodigo(produto.getCodigo());
            produto.setCategoria(categoria);
            
            Produto novoProduto = produtoRepository.create(produto);
            return Response.created(URI.create("/Produtos")).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }        
    }
}
