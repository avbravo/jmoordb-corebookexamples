package com.jmoordbcore.capitulo13;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api")
@OpenAPIDefinition(info = @Info(
        title = "RESTful API",
        description = "capitulo 02",
        version = "1.0.0-Snapshot",
        contact = @Contact(
                name = "AVbravo",
                email = "avbravo@gmail.com",
                url = "https://avbravo.blogspot.com")
),
        servers = {
            @Server(url = "http://localhost:8080/", description = "Local Development Server "),}
)
public class JakartaRestConfiguration extends Application {
    
}
