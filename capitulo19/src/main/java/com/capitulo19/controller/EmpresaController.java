/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo19.controller;

import com.capitulo19.model.Empresa;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.capitulo19.repository.EmpresaRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;   
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.eclipse.microprofile.metrics.MetricUnits;

import org.eclipse.microprofile.metrics.annotation.Timed;
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
@Path("empresa")
@Tag(name = "Información del empresa", description = "End-point para entidad Empresa")
@RolesAllowed({"admin"})
public class EmpresaController {

    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    EmpresaRepository empresaRepository;

    

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @RolesAllowed({"admin"})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Timed(name = "empresaesFindAll",
            description = "Monitorea el tiempo en que se obtiene la lista de todos los empresaes",
            unit = MetricUnits.MILLISECONDS, absolute = true)
    @Operation(summary = "Obtiene todos los empresaes", description = "Retorna todos los empresaes disponibles")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @APIResponse(responseCode = "200", description = "Los empresaes")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "Los empresaes", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los empresas", required = true, name = "empresaes")))
    public List<Empresa> findAll() {
        List<Empresa> empresaList = new ArrayList<>();

        return empresaRepository.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Empresa findByIdempresa">
    @GET
    @RolesAllowed({"admin"})
    @Path("{idempresa}")
    @Operation(summary = "Busca un empresa por el idempresa", description = "Busqueda de empresa por idempresa")
    @APIResponse(responseCode = "200", description = "El empresa")
    @APIResponse(responseCode = "404", description = "Cuando no existe el idempresa")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El empresa", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Empresa.class)))
    public Empresa findByIdempresa(
            @Parameter(description = "El idempresa", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idempresa") Long idempresa) {

        return empresaRepository.findByPk(idempresa).orElseThrow(
                () -> new WebApplicationException("No hay empresa con idempresa " + idempresa, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Empresa findByEmpresa">
    @GET
    @RolesAllowed({"admin"})
    @Path("empresa")
    @Operation(summary = "Busca un empresa por proyecti", description = "Busqueda de empresa por empresa")
    @APIResponse(responseCode = "200", description = "El empresa")
    @APIResponse(responseCode = "404", description = "Cuando no existe el empresa")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El empresa", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Empresa.class)))

    public List<Empresa> findByEmpresa(@Parameter(description = "El empresa", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("empresa") final String empresa) {

        return empresaRepository.findByEmpresa(empresa);

    }
//// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response save">

    @POST
    @RolesAllowed({"admin"})
    @Operation(summary = "Inserta un nuevo empresa", description = "Inserta un nuevo empresa")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  empresa")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response save(
            @RequestBody(description = "Crea un nuevo empresa.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empresa.class))) Empresa empresa) {

        Optional<Empresa> empresaOptional = empresaRepository.save(empresa);
        if (empresaOptional.isPresent()) {
//            saveHistory(empresa);
            return Response.status(201).entity(empresaOptional.get()).build();
        } else {
            return Response.status(400).entity("Error " + empresaRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT
    @RolesAllowed({"admin"})
    @Operation(summary = "Inserta un nuevo empresa", description = "Inserta un nuevo empresa")
    @APIResponse(responseCode = "201", description = "Cuando se crea un  empresa")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response update(
            @RequestBody(description = "Crea un nuevo empresa.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empresa.class))) Empresa empresa) {

        if (empresaRepository.update(empresa)) {
//            saveHistory(empresa);
            return Response.status(201).entity(empresa).build();
        } else {

            return Response.status(400).entity("Error " + empresaRepository.getJmoordbException().getLocalizedMessage()).build();

        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @RolesAllowed({"admin"})
    @Path("{idempresa}")
    @Operation(summary = "Elimina un empresa por  idempresa", description = "Elimina un empresa por su idempresa")
    @APIResponse(responseCode = "200", description = "Cuando elimina el empresa")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response delete(
            @Parameter(description = "El elemento idempresa", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idempresa") Long idempresa) {

        if (empresaRepository.deleteByPk(idempresa) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + empresaRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="List<User> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size)">
    @GET
    @Path("lookup")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca un empresa", description = "Busqueda de empresa por search")
    @APIResponse(responseCode = "200", description = "User")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Empresa.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Empresa> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        List<Empresa> suggestions = new ArrayList<>();
        try {

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);

            suggestions = empresaRepository.lookup(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return suggestions;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size)">
    @GET
    @Path("count")
    @RolesAllowed({"admin"})
    @Operation(summary = "Cuenta ", description = "Cuenta empresa")
    @APIResponse(responseCode = "200", description = "contador")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Empresa.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        Long result = 0L;
        try {

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
            result = empresaRepository.count(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }

    // </editor-fold>
  
    // <editor-fold defaultstate="collapsed" desc="Long countLikeEmpresa(@QueryParam("empresa") String empresa)">
    @GET
    @Path("countlikebyempresa")
    @RolesAllowed({"admin"})
    @Operation(summary = "Cuenta ", description = "Cuenta tarjeta")
    @APIResponse(responseCode = "200", description = "contador")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Empresa.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Long countLikeEmpresa(@QueryParam("empresa") String empresa) {
        Long result = 0L;
        try {
            result = empresaRepository.countLikeByEmpresa(empresa);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" List<Empresa> likeByName(@QueryParam("empresa") String empresa)">
    @GET
    @Path("likebyempresa")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca un user", description = "Busqueda de user usando like%")
    @APIResponse(responseCode = "200", description = "UserView")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Empresa.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Empresa> likeByName(@QueryParam("empresa") String empresa) {
        List<Empresa> suggestions = new ArrayList<>();
        try {
            suggestions = empresaRepository.likeByEmpresa(empresa);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
        return suggestions;
    }

    // </editor-fold>
}
