/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Oceano;
import com.avbravo.mongodbatlasdriver.repository.OceanoRepository;
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
@Path("/oceano")
@Tag(name = "Config Retrieval oceano", description = "Get the value for oceano")
public class OceanoController {

 private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    OceanoRepository oceanoRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Get all oceano", description = "Returns all available items at the oceano")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "The oceanos")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The oceanos", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "the oceanos", required = true, name = "oceanos")))
    public List<Oceano> get() {
        List<Oceano> list = new ArrayList<>();
        try {
          
            list = oceanoRepository.findAll();

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return list;
    }


    
    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Oceano> findAll() {
        return oceanoRepository.findAll();
    }
    
    @GET
    @Path("{id}")
    @Operation(summary = "Find a oceano by id", description = "Find a oceano by id")
    @APIResponse(responseCode = "200", description = "The oceano")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The oceano", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Oceano.class)))
    public Oceano findById(
            @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
        return oceanoRepository.findById(id).orElseThrow(
                () -> new WebApplicationException("There is no oceano with the id " + id, Response.Status.NOT_FOUND));
    }
    
    @GET
    @Path("/ping")
    @Operation(summary = "Ping a la base de datos", description = "Hace un ping a la base de datos")
    @APIResponse(responseCode = "200", description = "The oceano")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The ping", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Oceano.class)))
    public Boolean ping(){
            
        return oceanoRepository.ping().booleanValue();
    }
    
    
     @POST
    @Operation(summary = "Insert a oceano", description = "Insert a oceano")
    @APIResponse(responseCode = "201", description = "When creates an oceano")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response insert(
            @RequestBody(description = "Create a new oceano.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Oceano.class))) Oceano oceano) {
        return Response.status(Response.Status.CREATED).entity(oceanoRepository.save(oceano)).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a oceano by ID", description = "Delete a oceano by ID")
    @APIResponse(responseCode = "200", description = "When deletes the oceano")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response delete(
       @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
      oceanoRepository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
