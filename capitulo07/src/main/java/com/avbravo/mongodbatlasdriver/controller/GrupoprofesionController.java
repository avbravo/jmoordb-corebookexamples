/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Grupoprofesion;
import com.avbravo.mongodbatlasdriver.repository.GrupoprofesionRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


/**
 *
 * @author avbravo
 */
@Path("/grupoprofesion")
@Tag(name = "Config Retrieval grupoprofesion", description = "Get the value for grupoprofesion")
public class GrupoprofesionController {

 private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    GrupoprofesionRepository grupoprofesionRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Get all grupoprofesion", description = "Returns all available items at the grupoprofesion")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "The grupoprofesions")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The grupoprofesions", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "the grupoprofesions", required = true, name = "grupoprofesions")))
    public List<Grupoprofesion> get() {
        List<Grupoprofesion> list = new ArrayList<>();
        try {
          
            list = grupoprofesionRepository.findAll();

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return list;
    }


    
    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Grupoprofesion> findAll() {
        return grupoprofesionRepository.findAll();
    }
    
     @GET
    @Path("{id}")
    @Operation(summary = "Find a grupoprofesion by id", description = "Find a grupoprofesion by id")
    @APIResponse(responseCode = "200", description = "The grupoprofesion")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The grupoprofesion", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Grupoprofesion.class)))
    public Grupoprofesion findById(
            @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
        return grupoprofesionRepository.findById(id).orElseThrow(
                () -> new WebApplicationException("There is no grupoprofesion with the id " + id, Response.Status.NOT_FOUND));
    }
    
    
     @POST
    @Operation(summary = "Insert a grupoprofesion", description = "Insert a grupoprofesion")
    @APIResponse(responseCode = "201", description = "When creates an grupoprofesion")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response insert(
            @RequestBody(description = "Create a new grupoprofesion.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Grupoprofesion.class))) Grupoprofesion grupoprofesion) {
        return Response.status(Response.Status.CREATED).entity(grupoprofesionRepository.save(grupoprofesion)).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a grupoprofesion by ID", description = "Delete a grupoprofesion by ID")
    @APIResponse(responseCode = "200", description = "When deletes the grupoprofesion")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response delete(
       @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
      grupoprofesionRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
