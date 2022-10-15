/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Profesion;
import com.avbravo.mongodbatlasdriver.repository.ProfesionRepository;
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
@Path("/profesion")
@Tag(name = "Config Retrieval profesion", description = "Get the value for profesion")
public class ProfesionController {

 private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    ProfesionRepository profesionRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Get all profesion", description = "Returns all available items at the profesion")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "The profesions")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The profesions", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "the profesions", required = true, name = "profesions")))
    public List<Profesion> get() {
        List<Profesion> list = new ArrayList<>();
        try {
          
            list = profesionRepository.findAll();

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return list;
    }


    
    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Profesion> findAll() {
        return profesionRepository.findAll();
    }
    
     @GET
    @Path("{id}")
    @Operation(summary = "Find a profesion by id", description = "Find a profesion by id")
    @APIResponse(responseCode = "200", description = "The profesion")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The profesion", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Profesion.class)))
    public Profesion findById(
            @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
        return profesionRepository.findById(id).orElseThrow(
                () -> new WebApplicationException("There is no profesion with the id " + id, Response.Status.NOT_FOUND));
    }
    
    
     @POST
    @Operation(summary = "Insert a profesion", description = "Insert a profesion")
    @APIResponse(responseCode = "201", description = "When creates an profesion")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response insert(
            @RequestBody(description = "Create a new profesion.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Profesion.class))) Profesion profesion) {
        return Response.status(Response.Status.CREATED).entity(profesionRepository.save(profesion)).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a profesion by ID", description = "Delete a profesion by ID")
    @APIResponse(responseCode = "200", description = "When deletes the profesion")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response delete(
       @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
      profesionRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
