/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.capitulo18.controller;

import com.jmoordb.capitulo18.model.Estudiante;
import com.jmoordb.capitulo18.repository.EstudianteRepository;
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

/**
 *
 * @author avbravo
 */
@Path("estudiante")
@Tag(name = "Información del estudiante", description = "End-point para entidad Estudiante")
public class EstudianteController {

    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    EstudianteRepository estudianteRepository;

 

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   
    public List<Estudiante> findAll() {

        return estudianteRepository.findAll().toList();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Estudiante findByIdestudiante">
    @GET
    @Path("{idestudiante}")
    
    public Estudiante findByIdestudiante(
            @Parameter(description = "El idestudiante", required = true, example = "1", schema = @Schema(type = SchemaType.INTEGER)) @PathParam("idestudiante") Long idestudiante) {

    

        return estudianteRepository.findById(idestudiante).orElseThrow(
                () -> new WebApplicationException("No hay estudiante con idestudiante " + idestudiante, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST
        public Response save(
            @RequestBody(description = "Crea un nuevo estudiante.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.save(estudiante)).build();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT
 
    public Response update(
            @RequestBody(description = "Crea un nuevo estudiante.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.save(estudiante)).build();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("{idestudiante}")
  public Response delete(
            @Parameter(description = "El elemento idestudiante", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("idestudiante") Long idestudiante) {
   
        estudianteRepository.deleteById(idestudiante);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    // </editor-fold>

    @GET
    @Path("findbynombre")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findByNombre(@QueryParam("nombre") String nombre) {
        return estudianteRepository.findByNombre(nombre);

    }

   
}
