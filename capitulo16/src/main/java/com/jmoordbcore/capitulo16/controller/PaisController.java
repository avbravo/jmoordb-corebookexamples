/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo16.controller;

import com.jmoordbcore.capitulo16.model.Pais;
import com.jmoordbcore.capitulo16.repository.PaisRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Path("pais")
public class PaisController {
// <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    PaisRepository paisRepository;

// </editor-fold>
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Path("findbypais")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findByPais(@QueryParam("pais") String pais) {
        return paisRepository.findByPais(pais);
    }
}
