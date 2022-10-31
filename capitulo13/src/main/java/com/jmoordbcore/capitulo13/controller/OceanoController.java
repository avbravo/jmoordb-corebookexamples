/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.controller;

import com.jmoordbcore.capitulo13.model.Oceano;
import com.jmoordbcore.capitulo13.model.Persona;
import com.jmoordbcore.capitulo13.repository.OceanoRepository;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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
