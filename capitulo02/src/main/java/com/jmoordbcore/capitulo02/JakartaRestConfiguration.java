package com.jmoordbcore.capitulo02;




import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;


@ApplicationPath("api")
@OpenAPIDefinition(info = @Info(
        title = "Jmoordbcore",
        description = "capitulo 02",
        version = "1.0.0-Snapshot",
        contact = @Contact(
                name = "AVbravo",
                email = "avbravo@gmail.com",
                url = "https://avbravo.blogspot.com")
),
        servers = {
            @Server(url = "http://localhost:8080/", description = "Servidor Local "),}
)
public class JakartaRestConfiguration extends Application {
    
}
