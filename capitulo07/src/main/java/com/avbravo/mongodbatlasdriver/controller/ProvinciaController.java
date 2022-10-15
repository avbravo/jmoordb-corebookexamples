/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Provincia;
import com.avbravo.mongodbatlasdriver.repository.ProvinciaRepository;
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
@Path("/provincia")
@Tag(name = "Config Retrieval provincia", description = "Get the value for provincia")
public class ProvinciaController {

 private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    ProvinciaRepository provinciaRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Get all provincia", description = "Returns all available items at the provincia")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "The provincias")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The provincias", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "the provincias", required = true, name = "provincias")))
    public List<Provincia> get() {
        List<Provincia> list = new ArrayList<>();
        try {
          
            list = provinciaRepository.findAll();

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return list;
    }


    
    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Provincia> findAll() {
        return provinciaRepository.findAll();
    }
    
     @GET
    @Path("{id}")
    @Operation(summary = "Find a provincia by id", description = "Find a provincia by id")
    @APIResponse(responseCode = "200", description = "The provincia")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The provincia", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Provincia.class)))
    public Provincia findById(
            @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
        return provinciaRepository.findById(id).orElseThrow(
                () -> new WebApplicationException("There is no provincia with the id " + id, Response.Status.NOT_FOUND));
    }
    
    
     @POST
    @Operation(summary = "Insert a provincia", description = "Insert a provincia")
    @APIResponse(responseCode = "201", description = "When creates an provincia")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response insert(
            @RequestBody(description = "Create a new provincia.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Provincia.class))) Provincia provincia) {
        return Response.status(Response.Status.CREATED).entity(provinciaRepository.save(provincia)).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a provincia by ID", description = "Delete a provincia by ID")
    @APIResponse(responseCode = "200", description = "When deletes the provincia")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response delete(
       @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
      provinciaRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
