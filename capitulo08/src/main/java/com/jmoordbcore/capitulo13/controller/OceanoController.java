/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.controller;

import com.jmoordbcore.capitulo13.model.Oceano;
import com.jmoordbcore.capitulo13.repository.OceanoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    // <editor-fold defaultstate="collapsed" desc="Persona findByIdoceano">
    @GET
    @Path("{idoceano}")
   
    public Oceano findByIdoceano(@PathParam("idoceano") String idoceano) {


        return oceanoRepository.findByIdoceano(idoceano).orElseThrow(
                () -> new WebApplicationException("No hay oceano con idoceano " + idoceano, Response.Status.NOT_FOUND));

    }
// </editor-fold>

}
