/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.controller;

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
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import com.jmoordbcore.model.Estudiante;
import com.jmoordbcore.repository.EstudianteRepository;

/**
 *
 * @author avbravo
 */

@Path("estudiante")
@Tag(name = "Información del estudiante", description = "End-point para entidad Estudiante")
public class EstudianteController {

    @Inject
    EstudianteRepository estudianteRepository;

    


    @GET
    @Produces(MediaType.APPLICATION_JSON)
       public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @GET
    @Path("{idestudiante}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public Estudiante findByIdestudiante(
            @Parameter(description = "El idestudiante", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("idestudiante") String idestudiante) {  
        return estudianteRepository.findByPk(idestudiante).orElseThrow(
                () -> new WebApplicationException("No hay estudiante con idestudiante " + idestudiante, Response.Status.NOT_FOUND));

    }


    @POST
    public Response save(
            @RequestBody(description = "Crea un nuevo estudiante.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.save(estudiante)).build();
    }

    @PUT
     public Response update(
            @RequestBody(description = "Crea un nuevo estudiante.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.update(estudiante)).build();
    }

    @DELETE
    @Path("{idestudiante}")
    public Response delete(
            @Parameter(description = "El elemento idestudiante", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("idestudiante") String idestudiante) {
        estudianteRepository.deleteByPk(idestudiante);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


    @GET
    @Path("findbynombre")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public List<Estudiante> findByNombre(@QueryParam("nombre") String nombre) {
        return estudianteRepository.findByNombre(nombre);

    }

  
}