/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.controller;

import com.capitulo20.model.Pais;
import com.capitulo20.repository.PaisRepository;
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
@Path("pais")
public class PaisController {

    @Inject
    PaisRepository paisRepository;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findAll() {

        return paisRepository.findAll();
    }

    @GET
    @Path("{idpais}")
    public Pais findByIdpais(
            @Parameter(description = "El idpais", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idpais") Long idpais) {

        return paisRepository.findByPk(idpais).orElseThrow(
                () -> new WebApplicationException("No hay pais con idpais " + idpais, Response.Status.NOT_FOUND));

    }

    @POST
    public Response save(
            @RequestBody(description = "Crea un nuevo pais.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pais.class))) Pais pais) {

        return Response.status(Response.Status.CREATED).entity(paisRepository.save(pais)).build();
    }

    @PUT
    public Response update(
            @RequestBody(description = "Crea un nuevo pais.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pais.class))) Pais pais) {

        return Response.status(Response.Status.CREATED).entity(paisRepository.update(pais)).build();
    }

    @DELETE
    @Path("{idpais}")
    public Response delete(
            @Parameter(description = "El elemento idpais", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idpais") Long idpais) {
        paisRepository.deleteByPk(idpais);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
