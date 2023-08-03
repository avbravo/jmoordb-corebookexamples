/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo20.controller;

import com.jmoordbcore.capitulo20.model.Oceano;
import com.jmoordbcore.capitulo20.repository.OceanoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Path("oceano")
public class OceanoController {
    @Inject
    OceanoRepository oceanoRepository;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Oceano> findAll(){
        return oceanoRepository.findAll();
    }
}
