package com.jmoordbcore;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {
// <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    Config config;
    @Inject
    @ConfigProperty(name = "mongodb.uri")
    String mongodburi;
// </editor-fold>
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
//        return "Hello from RESTEasy Reactive";
         return "Mongodburi= " + mongodburi; 
    }
}