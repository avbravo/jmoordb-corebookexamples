/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo16.controller;
import com.jmoordbcore.capitulo16.model.Libro;
import com.jmoordbcore.capitulo16.repository.LibroRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

/**
 *
 * @author avbravo
 */
@Path("libro")
public class LibroController {

    @Inject
    LibroRepository libroRepository;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @GET
    @Path("{isbn}")
    public Libro findByIdlibro(@PathParam("isbn") String isbn) {

        return libroRepository.findByPk(isbn).orElseThrow(
                () -> new WebApplicationException("No hay libro con isbn " + isbn, Response.Status.NOT_FOUND));

    }
//
    @POST
    public Response save(
            @RequestBody(description = "Crea un nuevo libro.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Libro.class))) Libro libro) {

        return Response.status(Response.Status.CREATED).entity(libroRepository.save(libro)).build();
    }
//
    @PUT
    public Response update(
            @RequestBody(description = "Crea un nuevo libro.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Libro.class))) Libro libro) {

        return Response.status(Response.Status.CREATED).entity(libroRepository.update(libro)).build();
    }
//
    @DELETE
    @Path("{isbn}")
    public Response delete( @PathParam("isbn") String isbn) {
        libroRepository.deleteByPk(isbn);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}