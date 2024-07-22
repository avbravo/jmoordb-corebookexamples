/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.controller;

import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.estacionesserver.model.Persona;
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
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import com.capitulo20.repository.PersonaRepository;
import com.jmoordb.core.annotation.date.DateFormat;
import java.util.Date;

/**
 *
 * @author avbravo
 */
@Path("persona")
@RequestScoped
public class PersonaController implements Serializable {


 
    @Inject
    PersonaRepository medicionRepository;


    @GET 
    public List<Persona> findAll() {
         return medicionRepository.findAll();
    }

    @GET 
    @Path("id")
    public Persona findById(@QueryParam("id") String id) {
         return medicionRepository.findByPk(new ObjectId(id)).orElseThrow(
                () -> new WebApplicationException("No hay medicion con idmedicion " + id, Response.Status.NOT_FOUND));

    }
    
    
     @GET
    @Path("fechatimestamp")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Persona fechatimestamp(@QueryParam("fecha") @DateFormat("yyyy-MM-ddThh:mm:ssZ[UTC]") final Date fecha,@QueryParam("timestamp") Integer timestamp) {
     

         System.out.println("\tfecha "+fecha);
         System.out.println("\ttimestamp "+timestamp);

            ObjectId id = new ObjectId();
            
   return medicionRepository.findByPk(new ObjectId(id.toString())).orElseThrow(
                () -> new WebApplicationException("No hay medicion con idmedicion " + id, Response.Status.NOT_FOUND));

      
    }
    
    
    @POST
    public Response save(
            @RequestBody(description = "Crea una persona.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) Persona medicion) {
        Optional<Persona> medicionOptional = medicionRepository.save(medicion);
        if (medicionOptional.isPresent()) {

            return Response.status(201).entity(medicionOptional.get()).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }

    }

    @PUT
    public Response update(
            @RequestBody(description = "Actualiza persona", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) Persona medicion) {
        
        if (medicionRepository.update(medicion)) {
            return Response.status(201).entity(medicion).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    @DELETE
    @Path("id")
      public Response delete(@QueryParam("id") String id) {
           
        if (medicionRepository.deleteByPk(new ObjectId(id)) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    @DELETE
    @Path("deletemany")
    public Response deleteMany(@QueryParam("filter") String filter, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
       
        Search search = DocumentUtil.convertForLookup(filter, "", 0, 0);
        if (medicionRepository.deleteMany(search) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
 
    @GET
    @Path("lookup")
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

    
    @GET
    @Path("count")
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

        
}
