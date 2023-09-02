package com.jmoordbcore;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {
    @Inject
    Config config;
    @Inject
    @ConfigProperty(name = "mongodb.uri")
    String mongodburi;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    return "Mongodburi= " + mongodburi; 
    }
}
