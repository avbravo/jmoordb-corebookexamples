/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Corregimiento;
import com.avbravo.mongodbatlasdriver.repository.CorregimientoRepository;
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
@Path("/corregimiento")
@Tag(name = "Config Retrieval corregimiento", description = "Get the value for corregimiento")
public class CorregimientoController {

 private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    CorregimientoRepository corregimientoRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Get all corregimiento", description = "Returns all available items at the corregimiento")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "The corregimientos")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The corregimientos", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "the corregimientos", required = true, name = "corregimientos")))
    public List<Corregimiento> get() {
        List<Corregimiento> list = new ArrayList<>();
        try {
          
            list = corregimientoRepository.findAll();

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return list;
    }


    
    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Corregimiento> findAll() {
        return corregimientoRepository.findAll();
    }
    
     @GET
    @Path("{id}")
    @Operation(summary = "Find a corregimiento by id", description = "Find a corregimiento by id")
    @APIResponse(responseCode = "200", description = "The corregimiento")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The corregimiento", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Corregimiento.class)))
    public Corregimiento findById(
            @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
        return corregimientoRepository.findById(id).orElseThrow(
                () -> new WebApplicationException("There is no corregimiento with the id " + id, Response.Status.NOT_FOUND));
    }
    
    
     @POST
    @Operation(summary = "Insert a corregimiento", description = "Insert a corregimiento")
    @APIResponse(responseCode = "201", description = "When creates an corregimiento")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response insert(
            @RequestBody(description = "Create a new corregimiento.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Corregimiento.class))) Corregimiento corregimiento) {
        return Response.status(Response.Status.CREATED).entity(corregimientoRepository.save(corregimiento)).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a corregimiento by ID", description = "Delete a corregimiento by ID")
    @APIResponse(responseCode = "200", description = "When deletes the corregimiento")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response delete(
       @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
      corregimientoRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
