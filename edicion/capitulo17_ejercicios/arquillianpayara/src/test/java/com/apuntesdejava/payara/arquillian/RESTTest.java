package com.apuntesdejava.payara.arquillian;

import com.apuntesdejava.arquillian.config.ApplicationConfig;
import com.apuntesdejava.arquillian.controller.GrupoController;
import com.apuntesdejava.arquillian.model.Grupo;
import com.apuntesdejava.arquillian.repository.GrupoRepository;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;
import static jakarta.ws.rs.core.Response.Status.OK;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Diego Silva <diego.silva@apuntesdejava.com>
 */
@RunWith(Arquillian.class)
public class RESTTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RESTTest.class);

    @ArquillianResource
    private URL deploymentURL; //el URL donde se desplegó el war

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "capitulo18.war")
//                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addClasses(GrupoController.class,
                    
                        GrupoRepository.class,
                                             ApplicationConfig.class,
                        Grupo.class);
    }

    @Test
 //   @UsingDataSet("datasets/products.yml")
    public void testFindGrupo() throws URISyntaxException {
        Client client = createClient(); //creamos el cliente
        WebTarget target = client.target(deploymentURL.toURI()) //registramos el servidor...
                .path("api/grupo") //.. el path del servicio...
                .queryParam("name", "DE"); //... y los parámetros
        LOGGER.info("--- test find product:{}", target.getUri());
        Response response = target.request(MediaType.APPLICATION_JSON).get(); //invocamos al servicio por GET
        if (response.getStatus() != HttpStatus.OK_200.getStatusCode()) { //si no es correcto..
            fail("Error :" + response.getStatusInfo().getReasonPhrase()); //.. lanza el error y termina
        }
        //si todo está bien, tratamos de leer el contenido como la lista de Grupoos esperado
        List<Grupo> data = response.readEntity(new GenericType<List<Grupo>>() {
        });
        Assert.assertFalse(data.isEmpty()); //.. no debería estar vacía la lista.
        data.forEach((p) -> {
            LOGGER.info("\tproduct:{}", p.getGrupo()); //mostramos el contenido.
        });

    }


    private static Client createClient() {
        return ClientBuilder
                .newBuilder()
                .register(JacksonJaxbJsonProvider.class) //para procesar las peticiones como JSON
                .build();
    }

}
