/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.mockito;

import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

/**
 *
 * @author avbravo
 */
@Path("hello")
public class HelloResource {
    @Inject
    GreetingService greetingService;
    
    @GET
    @Path("{vistor}")
    public JsonObject hello(@PathParam("vistor") final String visitor){
        return greetingService.greet(visitor);
    }
    
}
