/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.controller;

import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.estacionesserver.model.Persona;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import com.estacionesserver.repository.PersonaRepository;

/**
 *
 * @author avbravo
 */
@Path("persona")
@Tag(name = "Información del medicion", description = "End-point para entidad Medicion")
@RolesAllowed({"admin"})
@RequestScoped
public class PersonaController implements Serializable {


    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    PersonaRepository medicionRepository;


// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Medicion findByIdmedicionIdproyecto(@QueryParam("idmedicion") Long idmedicion,       @QueryParam("anio") Long anio  ) ">
    @GET
    @RolesAllowed({"admin"})
    @Path("id")
    @Operation(summary = "Busca un medicion por el idmedicion", description = "Busqueda de medicion por idmedicion")
    @APIResponse(responseCode = "200", description = "El medicion")
    @APIResponse(responseCode = "404", description = "Cuando no existe el idmedicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El medicion", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Persona.class)))
    public Persona findById(@QueryParam("id") String id) {

  
        return medicionRepository.findByPk(new ObjectId(id)).orElseThrow(
                () -> new WebApplicationException("No hay medicion con idmedicion " + id, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST
    @RolesAllowed({"admin"})
    @Operation(summary = "Inserta un nuevo medicion", description = "Inserta un nuevo medicion")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  medicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response save(
            @RequestBody(description = "Crea un nuevo medicion.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) Persona medicion) {

     

        
        Optional<Persona> medicionOptional = medicionRepository.save(medicion);
        if (medicionOptional.isPresent()) {

            return Response.status(201).entity(medicionOptional.get()).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response update">
    @PUT
    @RolesAllowed({"admin"})
    @Operation(summary = "Inserta un nuevo medicion", description = "Inserta un nuevo medicion")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  medicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response update(
            @RequestBody(description = "Crea un nuevo medicion.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) Persona medicion) {


        
        if (medicionRepository.update(medicion)) {

            return Response.status(201).entity(medicion).build();
        } else {
            System.out.println("\t>>>>>>>> [error]" + MessagesUtil.nameOfClassAndMethod());
            System.out.println("\t>>>>>>>> [error]" + MessagesUtil.nameOfClassAndMethod() + " [error] " + medicionRepository.getJmoordbException().getLocalizedMessage());
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete(@QueryParam("idmedicion") Long idmedicion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) ">
    @DELETE
    @RolesAllowed({"admin"})
    @Path("id")
    @Operation(summary = "Elimina un medicion por  idmedicion", description = "Elimina un medicion por su idmedicion")
    @APIResponse(responseCode = "200", description = "Cuando elimina el medicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response delete(@QueryParam("id") String id) {
       
    
        if (medicionRepository.deleteByPk(new ObjectId(id)) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response deleteMany(@QueryParam("filter") String filter @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes)">
    @DELETE
    @Path("deletemany")
    @RolesAllowed({"admin"})
    @Operation(summary = "Elimina un medicion por  idmedicion", description = "Elimina un medicion por su idmedicion")
    @APIResponse(responseCode = "200", description = "Cuando elimina el medicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response deleteMany(@QueryParam("filter") String filter, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
       
        Search search = DocumentUtil.convertForLookup(filter, "", 0, 0);
        if (medicionRepository.deleteMany(search) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Medicion> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size,@QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes)">
    @GET
    @Path("lookup")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca un medicion", description = "Busqueda de medicion por search")
    @APIResponse(responseCode = "200", description = "Medicion")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Persona.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Persona> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
     
        List<Persona> suggestions = new ArrayList<>();
        try {

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
          
            suggestions = medicionRepository.lookup(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
        System.out.println("Resultado: " + suggestions);
        return suggestions;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("anio") Long anio)">
    @GET
    @Path("count")
    @RolesAllowed({"admin"})
    @Operation(summary = "Cuenta ", description = "Cuenta medicion")
    @APIResponse(responseCode = "200", description = "contador")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Persona.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        Long result = 0L;
        try{
            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
            result = medicionRepository.count(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }

    // </editor-fold>
    
    
}
