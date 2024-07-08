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
import java.util.List;
import java.util.Optional;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

/**
 *
 * @author avbravo
 */
@Path("empresa")

public class EmpresaController {

    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    EmpresaRepository empresaRepository;

    

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
       public List<Empresa> findAll() {
        List<Empresa> empresaList = new ArrayList<>();

        return empresaRepository.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Empresa findByIdempresa">
    @GET
    @Path("{idempresa}")
    public Empresa findByIdempresa(
            @Parameter(description = "El idempresa", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idempresa") Long idempresa) {

        return empresaRepository.findByPk(idempresa).orElseThrow(
                () -> new WebApplicationException("No hay empresa con idempresa " + idempresa, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Empresa findByEmpresa">
    @GET
    @Path("empresa")
    public List<Empresa> findByEmpresa(@Parameter(description = "El empresa", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("empresa") final String empresa) {

        return empresaRepository.findByEmpresa(empresa);

    }
//// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response save">

    @POST
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
    public Response update(
            @RequestBody(description = "Crea un nuevo empresa.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empresa.class))) Empresa empresa) {

        if (empresaRepository.update(empresa)) {
            return Response.status(201).entity(empresa).build();
        } else {

            return Response.status(400).entity("Error " + empresaRepository.getJmoordbException().getLocalizedMessage()).build();

        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("{idempresa}")
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
