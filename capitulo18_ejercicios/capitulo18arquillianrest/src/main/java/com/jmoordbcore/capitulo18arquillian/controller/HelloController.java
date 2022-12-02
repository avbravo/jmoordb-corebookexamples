package com.jmoordbcore.capitulo18arquillian.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@RequestScoped
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello World";
    }
}
