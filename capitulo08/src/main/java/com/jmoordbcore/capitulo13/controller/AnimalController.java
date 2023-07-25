/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.controller;

import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcore.capitulo13.model.Animal;
import com.jmoordbcore.capitulo13.model.Pais;
import com.jmoordbcore.capitulo13.repository.AnimalRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Path("animal")
public class AnimalController {
   
    @Inject
    AnimalRepository animalRepository;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Animal> findAll(){
        return animalRepository.findAll();
    }
    
    
}
