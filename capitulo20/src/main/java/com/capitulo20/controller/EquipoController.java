/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.controller;

import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.capitulo20.model.Equipo;
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
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import com.capitulo20.repository.EquipoRepository;
import java.util.UUID;

/**
 *
 * @author avbravo
 */
@Path("equipo")
@RequestScoped
public class EquipoController implements Serializable {


 
    @Inject
    EquipoRepository equipoRepository;


    @GET 
    public List<Equipo> findAll() {
         return equipoRepository.findAll();
    }

    @GET 
    @Path("id")
    public Equipo findById(@QueryParam("id") String id) {
    UUID _uuid=    UUID.fromString(id);
         return equipoRepository.findByPk(_uuid).orElseThrow(
                () -> new WebApplicationException("No hay equipo con idequipo " + id, Response.Status.NOT_FOUND));

    }
    
    
   
    
    
    @POST
    public Response save(
            @RequestBody(description = "Crea una equipo.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Equipo.class))) Equipo equipo) {
        Optional<Equipo> equipoOptional = equipoRepository.save(equipo);
        if (equipoOptional.isPresent()) {

            return Response.status(201).entity(equipoOptional.get()).build();
        } else {
            return Response.status(400).entity("Error " + equipoRepository.getJmoordbException().getLocalizedMessage()).build();
        }

    }

    @PUT
    public Response update(
            @RequestBody(description = "Actualiza equipo", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Equipo.class))) Equipo equipo) {
        
        if (equipoRepository.update(equipo)) {
            return Response.status(201).entity(equipo).build();
        } else {
            return Response.status(400).entity("Error " + equipoRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    @DELETE
    @Path("id")
      public Response delete(@QueryParam("id") String id) {
             UUID _uuid=    UUID.fromString(id);
        if (equipoRepository.deleteByPk(_uuid) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + equipoRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    @DELETE
    @Path("deletemany")
    public Response deleteMany(@QueryParam("filter") String filter, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
       
        Search search = DocumentUtil.convertForLookup(filter, "", 0, 0);
        if (equipoRepository.deleteMany(search) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + equipoRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
 
    @GET
    @Path("lookup")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Equipo> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
     
        List<Equipo> suggestions = new ArrayList<>();
        try {

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
          
            suggestions = equipoRepository.lookup(search);

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
            result = equipoRepository.count(search);

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }

        
}
