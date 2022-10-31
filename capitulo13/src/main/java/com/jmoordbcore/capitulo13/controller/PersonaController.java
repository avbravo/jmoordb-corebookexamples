/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.controller;

import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcore.capitulo13.model.Deporte;
import com.jmoordbcore.capitulo13.model.Musica;
import com.jmoordbcore.capitulo13.model.Oceano;
import com.jmoordbcore.capitulo13.model.Pais;
import com.jmoordbcore.capitulo13.model.Persona;
import com.jmoordbcore.capitulo13.repository.OceanoRepository;
import com.jmoordbcore.capitulo13.repository.PaisRepository;
import com.jmoordbcore.capitulo13.repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

/**
 *
 * @author avbravo
 */
@Path("persona")
public class PersonaController {
    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    PersonaRepository personaRepository;
    @Inject
    PaisRepository paisRepository;
    @Inject 
    OceanoRepository oceanoRepository;

   

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="  @Path("insert")">
    @Path("insert")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Persona> insert(@QueryParam("inicial") final Integer inicial) {

//   Integer limiteFactor = 13545;
   Integer limiteFactor = 2;

        Integer maximo = inicial + limiteFactor;
        for (int i = inicial; i <= maximo; i++) {

            Persona persona = new Persona();
            persona.setIdpersona(JmoordbCoreUtil.integerToLong(i));
            persona.setNombre("Persona - " + persona.getIdpersona());
            
             List<Oceano> oceanoList = new ArrayList<>();
             
             List<Musica> musicaList = new ArrayList<>();
            if(JmoordbCoreUtil.isPar(i)){
                 persona.setDeporte(new Deporte("baloncesto"));
                 oceanoList.add(oceanoRepository.findByIdoceano("pacifico").get()) ;
                 oceanoList.add(oceanoRepository.findByIdoceano("atlantico").get()) ;
                 musicaList.add(new Musica("Rock"));
                 musicaList.add(new Musica("Death Metal"));
            }else{
                 persona.setDeporte(new Deporte("futbol"));
                 oceanoList.add(oceanoRepository.findByIdoceano("indico").get()) ;
                     musicaList.add(new Musica("Salsa"));
            }
            
            persona.setOceano(oceanoList);
            persona.setMusica(musicaList);
            
            
            
           
           Optional<Pais> paisOptional= paisRepository.findByPk(JmoordbCoreUtil.integerToLong(i));
           if(paisOptional.isPresent()){
               persona.setPais(paisOptional.get());
           }else{
               persona.setPais(new Pais());
           }
           
           
           /**
            * Oceano
            * 
            */
          
           
           
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(">>>>> Pesona for Save >>>>>\n" +persona.toString());
            personaRepository.save(persona);
        }
        return new ArrayList<>();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    
        public List<Persona> findAll() {

        return personaRepository.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Persona findByIdpersona">
    @GET
    @Path("{idpersona}")
   
    public Persona findByIdpersona(
            @Parameter(description = "El idpersona", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idpersona") Long idpersona) {


        return personaRepository.findByPk(idpersona).orElseThrow(
                () -> new WebApplicationException("No hay persona con idpersona " + idpersona, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST
  
    public Response save(
            @RequestBody(description = "Crea un nuevo persona.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) Persona persona) {
     
        return Response.status(Response.Status.CREATED).entity(personaRepository.save(persona)).build();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT
    @Operation(summary = "Inserta un nuevo persona", description = "Inserta un nuevo persona")
   
    public Response update(
            @RequestBody(description = "Crea un nuevo persona.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) Persona persona) {
        return Response.status(Response.Status.CREATED).entity(personaRepository.save(persona)).build();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("{idpersona}")
   
    public Response delete(
            @Parameter(description = "El elemento idpersona", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idpersona") Long idpersona) {
        personaRepository.deleteByPk(idpersona);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="fechahora">

    @Path("fechahora")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
 
    public List<Persona> findByFecha(@QueryParam("fecha") String nombre) {

        return personaRepository.findByNombre(nombre);
    }
    // </editor-fold>

 
}
