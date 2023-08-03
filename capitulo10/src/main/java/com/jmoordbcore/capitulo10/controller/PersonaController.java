/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo10.controller;

import com.jmoordbcore.capitulo10.model.Persona;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import com.jmoordbcore.capitulo10.repository.PersonaRepository;

/**
 *
 * @author avbravo
 */
@Path("persona")
public class PersonaController {

    @Inject
    PersonaRepository personaRepository;

    @GET
    @jakarta.ws.rs.Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

}
