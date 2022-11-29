package com.jmoordbcore.test.capitulo02.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 *
 */
@Path("/oceano")
public interface OceanoControllerClient {

    @GET
    public String sayHello();

}