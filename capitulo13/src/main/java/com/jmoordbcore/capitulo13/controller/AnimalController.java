/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.controller;

import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcore.capitulo13.model.Animal;
import com.jmoordbcore.capitulo13.model.Pais;
import com.jmoordbcore.capitulo13.repository.AnimalRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
    
    // <editor-fold defaultstate="collapsed" desc="  @Path("insert")">
    @Path("insert")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Pais> insert(@QueryParam("inicial") final Integer inicial) {

        Integer limiteFactor = 13545;

        Integer maximo = inicial + limiteFactor;
        for (int i = inicial; i <= maximo; i++) {

            Pais pais = new Pais();
            pais.setIdpais(JmoordbCoreUtil.integerToLong(i));
            pais.setPais("Pais - " + pais.getIdpais());
            pais.setFecha(new Date());
           // paisRepository.save(pais);
        }
        return new ArrayList<>();
    }
// </editor-fold>
}
