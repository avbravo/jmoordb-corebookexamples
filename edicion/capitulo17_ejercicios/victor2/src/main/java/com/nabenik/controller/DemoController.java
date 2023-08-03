package com.nabenik.controller;


import com.nabenik.service.HelloService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

@Path("/demo")
public class DemoController {

    HelloService helloService;

    @Inject
    public DemoController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GET
    public String getHello(@QueryParam("name") @DefaultValue("victor") String name) {
        return helloService.createHello(name);
    }

}
