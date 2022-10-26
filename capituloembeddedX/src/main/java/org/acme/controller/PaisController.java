/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.controller;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.model.Pais;
import org.acme.repository.PaisRepository;

/**
 *
 * @author avbravo
 */
@Path("pais")
public class PaisController {
    @Inject
    PaisRepository paisRepository;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pais> findAll(){
        return paisRepository.findAll();
    }
    
}
