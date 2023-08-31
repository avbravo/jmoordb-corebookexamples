/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo17.controller;

import com.jmoordbcore.capitulo17.model.Estudiante;
import com.jmoordbcore.capitulo17.repository.EstudianteRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

/**
 *
 * @author avbravo
 */
@Path("estudiante")
public class EstudianteController {

    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    EstudianteRepository estudianteRepository;


// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces(MediaType.APPLICATION_JSON)
       public List<Estudiante> findAll() {

        return estudianteRepository.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Estudiante findByIdestudiante">
    @GET
    @Path("{idestudiante}")
 
    public Estudiante findByIdestudiante(@PathParam("idestudiante") String idestudiante) {

  

        return estudianteRepository.findByPk(idestudiante).orElseThrow(
                () -> new WebApplicationException("No hay estudiante con idestudiante " + idestudiante, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST
    public Response save(Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.save(estudiante)).build();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT
  
    public Response update(Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.update(estudiante)).build();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("{idestudiante}")
        public Response delete( @PathParam("idestudiante") String idestudiante) {
        estudianteRepository.deleteByPk(idestudiante);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    // </editor-fold>

    @GET
    @Path("findbynombre")
    @Produces(MediaType.APPLICATION_JSON)
     public List<Estudiante> findByNombre(@QueryParam("nombre") String nombre) {
        return estudianteRepository.findByNombre(nombre);

    }

   

}
