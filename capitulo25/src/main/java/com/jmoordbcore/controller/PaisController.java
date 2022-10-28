/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.controller;

import com.jmoordb.core.annotation.date.DateFormat;
import com.jmoordbcore.model.Pais;

import com.jmoordbcore.repository.PaisRepository;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author avbravo
 */
@Path("pais")

public class PaisController {


    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    PaisRepository paisRepository;


    

// </editor-fold>
   

    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findAll() {

        return paisRepository.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Pais findByIdpais">


    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST

    public Response save(Pais pais) {

        pais.setFecha(new Date());
        return Response.status(Response.Status.CREATED).entity(paisRepository.save(pais)).build();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT
  
    public Response update(  Pais pais) {

        pais.setFecha(new Date());
        return Response.status(Response.Status.CREATED).entity(paisRepository.save(pais)).build();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("{idpais}")
    
    public Response delete(@PathParam("idpais") Long idpais) {
        paisRepository.deleteByPk(idpais);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    // </editor-fold>
  

   
    // <editor-fold defaultstate="collapsed" desc="@Path("fechagreaterthanequalandfechalessthanequalandpais")">
    @Path("fechagreaterthanequalandfechalessthanequalandpais")
    @GET
    public List<Pais> findByFechaGreaterThanEqualAndFechaLessThanEqualAndPais(@QueryParam("fecha") @DateFormat final Date fecha, @QueryParam("fechafinal") @DateFormat final Date fechafinal, @QueryParam("pais") String pais) {
        return paisRepository.findByFechaGreaterThanEqualAndFechaLessThanEqualAndPais(fecha, fechafinal, pais);

    }

    // </editor-fold>



}
