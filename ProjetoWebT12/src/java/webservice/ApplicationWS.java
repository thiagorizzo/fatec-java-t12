package webservice;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationWS extends Application {

    // retorna webservices que a aplicação /api conterá
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> webservices = new HashSet<Class<?>>();
        
        // adicionar meus webservices
        webservices.add(ProdutoWS.class);
        
        return webservices;
    }
}
