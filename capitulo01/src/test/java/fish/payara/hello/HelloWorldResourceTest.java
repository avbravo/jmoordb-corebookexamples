package fish.payara.hello;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.net.URL;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@RunAsClient
public class HelloWorldResourceTest {


    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(HelloWorldResource.class)
                .addClass(RestConfiguration.class)
                .addAsResource(new File("src/main/resources/META-INF/microprofile-config.properties"))
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"));
    }
    
    @ArquillianResource
    private URL deploymentUrl;
    
    @Test
    public void testHelloEndpoint() {
        String baseUrl = deploymentUrl.toString();
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(baseUrl + "resources/hello")
                .queryParam("name", "John")
                .request(MediaType.TEXT_PLAIN)
                .get();


        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        String responseBody = response.readEntity(String.class);
        assertEquals("John", responseBody);

        client.close();
    }
}
