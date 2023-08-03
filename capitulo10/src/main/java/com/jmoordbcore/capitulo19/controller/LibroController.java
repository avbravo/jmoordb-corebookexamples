/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo19.controller;

import com.jmoordbcore.capitulo19.model.Libro;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import com.jmoordbcore.capitulo19.repository.LibroRepository;

/**
 *
 * @author avbravo
 */
@Path("libro")
public class LibroController {
    
    @Inject
    LibroRepository libroRepository;
    
    @GET
   @jakarta.ws.rs.Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Libro> findAll(){
        return  libroRepository.findAll();
                }

}
