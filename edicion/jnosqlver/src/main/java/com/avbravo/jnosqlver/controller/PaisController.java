/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jnosqlver.controller;

import com.avbravo.jnosqlver.model.Pais;
import com.avbravo.jnosqlver.repository.PaisRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
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
@Path("pais")
@Tag(name = "Información del pais", description = "End-point para entidad Pais")
public class PaisController {



    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    PaisRepository paisRepository;



    
// </editor-fold>



    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
       public List<Pais> findAll() {
        System.out.println(" Cargando lista de todos los paises,......");
        List<Pais> l =paisRepository.findAll().toList();
        System.out.println(" size(): "+l.size());
        return paisRepository.findAll().toList();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Pais findByIdpais">
    @GET
    @Path("{pais}")
    
    public List<Pais> findByPais(@QueryParam("pais") String pais) {


      return paisRepository.findByPais(pais);
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST
   @Operation(summary = "Inserta un nuevo pais", description = "Inserta un nuevo pais")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  pais")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response save(
            @RequestBody(description = "Crea un nuevo pais.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pais.class))) Pais pais) {

        
        return Response.status(Response.Status.CREATED).entity(paisRepository.save(pais)).build();
    }
// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc="Response update">
//
//    @PUT
//    @Operation(summary = "Inserta un nuevo pais", description = "Inserta un nuevo pais")
//    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  pais")
//    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
//    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
//    public Response update(
//            @RequestBody(description = "Crea un nuevo pais.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pais.class))) Pais pais) {
//
//
//       return Response.status(Response.Status.CREATED).entity(paisRepository.update(pais)).build();
//    }
//// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("{idpais}")
    @Operation(summary = "Elimina un pais por  idpais", description = "Elimina un pais por su idpais")
    @APIResponse(responseCode = "200", description = "Cuando elimina el pais")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response delete(
            @Parameter(description = "El elemento idpais", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idpais") Long idpais) {
        paisRepository.deleteById(idpais);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    // </editor-fold>
   


}
