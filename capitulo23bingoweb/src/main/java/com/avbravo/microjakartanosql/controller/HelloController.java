package com.avbravo.microjakartanosql.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author 
 */
@Path("hello")
public class HelloController {
       @Inject
    @ConfigProperty(name = "document")
        private String document;
    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE" + document)
                .build();
    }
}
