package webservice;

import enums.ProdutoRepositoryTypeEnum;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Produto;
import repository.IProdutoRepository;
import repository.ProdutoRepositoryFactory;

@Path("/Produto")
public class ProdutoWS {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> GetProdutos() {
        try {
            IProdutoRepository produtoRepository = ProdutoRepositoryFactory.create(ProdutoRepositoryTypeEnum.Database);
            List<Produto> produtos = produtoRepository.getAll();
            return produtos;
        } catch (Exception ex) {
            Logger.getLogger(ProdutoWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
