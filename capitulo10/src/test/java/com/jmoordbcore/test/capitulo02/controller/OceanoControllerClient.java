package com.jmoordbcore.test.capitulo02.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/oceano")
public interface OceanoControllerClient {

    @GET
    public String sayHello();

}