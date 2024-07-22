/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.controller;

import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.capitulo20.model.Jugador;
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
import com.capitulo20.repository.JugadorRepository;
import com.jmoordb.core.annotation.date.DateFormat;
import java.util.Date;

/**
 *
 * @author avbravo
 */
@Path("jugador")
@RequestScoped
public class JugadorController implements Serializable {


 
    @Inject
    JugadorRepository jugadorRepository;


    @GET 
    public List<Jugador> findAll() {
         return jugadorRepository.findAll();
    }

    @GET 
    @Path("id")
    public Jugador findById(@QueryParam("id") Long id) {
         return jugadorRepository.findByPk(id).orElseThrow(
                () -> new WebApplicationException("No hay jugador con idjugador " + id, Response.Status.NOT_FOUND));

    }
    
    
    
    
    
    @POST
    public Response save(
            @RequestBody(description = "Crea una jugador.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Jugador.class))) Jugador jugador) {
        Optional<Jugador> jugadorOptional = jugadorRepository.save(jugador);
        if (jugadorOptional.isPresent()) {

            return Response.status(201).entity(jugadorOptional.get()).build();
        } else {
            return Response.status(400).entity("Error " + jugadorRepository.getJmoordbException().getLocalizedMessage()).build();
        }

    }

    @PUT
    public Response update(
            @RequestBody(description = "Actualiza jugador", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Jugador.class))) Jugador jugador) {
        
        if (jugadorRepository.update(jugador)) {
            return Response.status(201).entity(jugador).build();
        } else {
            return Response.status(400).entity("Error " + jugadorRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    @DELETE
    @Path("id")
      public Response delete(@QueryParam("id") Long id) {
           
        if (jugadorRepository.deleteByPk(id) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + jugadorRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    @DELETE
    @Path("deletemany")
    public Response deleteMany(@QueryParam("filter") String filter, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
       
        Search search = DocumentUtil.convertForLookup(filter, "", 0, 0);
        if (jugadorRepository.deleteMany(search) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + jugadorRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
 
    @GET
    @Path("lookup")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Jugador> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
     
        List<Jugador> suggestions = new ArrayList<>();
        try {

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
          
            suggestions = jugadorRepository.lookup(search);

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
            result = jugadorRepository.count(search);

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }

        
}
