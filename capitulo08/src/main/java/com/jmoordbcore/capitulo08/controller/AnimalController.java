/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo08.controller;

import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcore.capitulo08.model.Animal;
import com.jmoordbcore.capitulo08.repository.AnimalRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@Path("animal")
public class AnimalController {

    @Inject
    AnimalRepository animalRepository;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }
    // <editor-fold defaultstate="collapsed" desc="Animal findByIdanimal(@PathParam("idanimal") Long idanimal)">

    @GET
    @Path("{idanimal}")

    public Animal findByIdanimal(@PathParam("idanimal") Long idanimal) {

        return animalRepository.findByPk(idanimal).orElseThrow(
                () -> new WebApplicationException("No hay animal con el id " + idanimal, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    @Path("/ordenado")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Animal> findByIdpersonaGreaterThanPaginationSorted(@QueryParam("edad") Integer edad, @QueryParam("pagina") Integer pagina, @QueryParam("registrosporpagina") Integer registrosporpagina,
            @QueryParam("orderby") String orderby) {

        List<Animal> animalList = new ArrayList<>();

        Sorted sorted = new Sorted(new Document(orderby, -1));

        Pagination pagination = new Pagination(pagina, registrosporpagina);

        animalList = animalRepository.findByEdadGreaterThanPaginationSorted(JmoordbCoreUtil.integerToLong(edad),
                pagination, sorted);
        return animalList;
    }

}
