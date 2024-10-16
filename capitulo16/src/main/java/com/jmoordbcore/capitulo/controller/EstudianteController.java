/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo.controller;

import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordbcore.capitulo16.model.Estudiante;
import com.jmoordbcore.capitulo16.repository.EstudianteRepository;
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
import java.util.ArrayList;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author avbravo
 */
@Path("estudiante")
public class EstudianteController {

    @Inject
    EstudianteRepository estudianteRepository;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Estudiante> findAll() {

        return estudianteRepository.findAll();
    }

    @GET
    @Path("{idestudiante}")
    public Estudiante findByIdestudiante(@PathParam("idestudiante") String idestudiante) {

        return estudianteRepository.findByPk(idestudiante).orElseThrow(
                () -> new WebApplicationException("No hay estudiante con idestudiante " + idestudiante, Response.Status.NOT_FOUND));

    }

    @POST
    public Response save(@RequestBody(description = "Crea un nuevo estudiante.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.save(estudiante)).build();
    }

    @PUT
    public Response update(
            @RequestBody(description = "Crea un nuevo estudiante.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.update(estudiante)).build();
    }

    @DELETE
    @Path("{idestudiante}")
    public Response delete(@PathParam("idestudiante") String idestudiante) {

        estudianteRepository.deleteByPk(idestudiante);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("findbynombre")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findByNombre(@QueryParam("nombre") String nombre) {

        return estudianteRepository.findByNombre(nombre);

    }

    @GET
    @Path("lookup")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        List<Estudiante> suggestions = new ArrayList<>();
        try {
            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
            suggestions = estudianteRepository.lookup(search);

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
        return suggestions;
    }

}
