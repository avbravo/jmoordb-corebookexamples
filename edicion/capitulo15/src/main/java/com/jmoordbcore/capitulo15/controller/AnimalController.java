/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo15.controller;

import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcore.capitulo15.model.Animal;
import com.jmoordbcore.capitulo15.model.Pais;
import com.jmoordbcore.capitulo15.repository.AnimalRepository;
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
    public List<Animal> findAll() {



            //Create the token from user details.
            /**
             * Funciona para cifrar pàssword con fecha de caducidad en base a un JWT
             */
           
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
