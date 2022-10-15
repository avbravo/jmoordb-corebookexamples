/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Persona;
import com.avbravo.mongodbatlasdriver.repository.PersonaRepository;
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
@Path("/persona")
@Tag(name = "Config Retrieval persona", description = "Get the value for persona")
public class PersonaController {

 private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    PersonaRepository personaRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Get all persona", description = "Returns all available items at the persona")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "The personas")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The personas", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "the personas", required = true, name = "personas")))
    public List<Persona> get() {
        List<Persona> list = new ArrayList<>();
        try {
          
            list = personaRepository.findAll();

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return list;
    }


    
    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }
    
     @GET
    @Path("{id}")
    @Operation(summary = "Find a persona by id", description = "Find a persona by id")
    @APIResponse(responseCode = "200", description = "The persona")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The persona", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Persona.class)))
    public Persona findById(
            @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
        return personaRepository.findById(id).orElseThrow(
                () -> new WebApplicationException("There is no persona with the id " + id, Response.Status.NOT_FOUND));
    }
    
    
     @POST
    @Operation(summary = "Insert a persona", description = "Insert a persona")
    @APIResponse(responseCode = "201", description = "When creates an persona")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response insert(
            @RequestBody(description = "Create a new persona.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) Persona persona) {
        return Response.status(Response.Status.CREATED).entity(personaRepository.save(persona)).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a persona by ID", description = "Delete a persona by ID")
    @APIResponse(responseCode = "200", description = "When deletes the persona")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response delete(
       @Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
      personaRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
