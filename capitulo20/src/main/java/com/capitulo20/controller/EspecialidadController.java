/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.controller;

import com.capitulo20.model.Especialidad;
import com.capitulo20.repository.EspecialidadRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

/**
 *
 * @author avbravo
 */
@Path("especialidad")
public class EspecialidadController {

    @Inject
    EspecialidadRepository especialidadRepository;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Especialidad> findAll() {

        return especialidadRepository.findAll();
    }

    @GET
    @Path("{idespecialidad}")
    public Especialidad findByIdespecialidad(
            @Parameter(description = "El idespecialidad", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idespecialidad") String idespecialidad) {

        return especialidadRepository.findByPk(idespecialidad).orElseThrow(
                () -> new WebApplicationException("No hay especialidad con idespecialidad " + idespecialidad, Response.Status.NOT_FOUND));

    }

    @POST
    public Response save(
            @RequestBody(description = "Crea un nuevo especialidad.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Especialidad.class))) Especialidad especialidad) {

        return Response.status(Response.Status.CREATED).entity(especialidadRepository.save(especialidad)).build();
    }

    @PUT
    public Response update(
            @RequestBody(description = "Crea un nuevo especialidad.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Especialidad.class))) Especialidad especialidad) {

        return Response.status(Response.Status.CREATED).entity(especialidadRepository.update(especialidad)).build();
    }

    @DELETE
    @Path("{idespecialidad}")
    public Response delete(
            @Parameter(description = "El elemento idespecialidad", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idespecialidad") String idespecialidad) {
        especialidadRepository.deleteByPk(idespecialidad);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
