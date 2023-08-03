/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.mockito;

import com.jmoordbcore.capitulo13.produces.ConfigPropertyProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class GreetingService {
    @Inject
    ConfigPropertyProvider propertyProvider;
    
    public JsonObject greet(String name){
        return Json.createObjectBuilder()
                .add("greeting", "Hello there "+name)
                .add("mongodburi",propertyProvider.getMongodburi())
                .build();
    }
}
