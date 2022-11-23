/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo18arquillian.controller;

import com.jmoordbcore.capitulo18arquillian.model.Grupo;
import com.jmoordbcore.capitulo18arquillian.repository.GrupoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author avbravo
 */
@Path("grupo")
public class GrupoController {
    @Inject
    GrupoRepository grupoRepository;
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Grupo> findAll(){
        return grupoRepository.findAll();
    }
    
    
      @POST
    public String createGrupo(@QueryParam("idgrupo") String idgrupo,
                             @QueryParam("grupo") String grupo) {
       Grupo grupoEntity = new Grupo(idgrupo, grupo);
        grupoRepository.save(grupoEntity);
        return grupoEntity.getIdgrupo();
    }
    
    @Path("findbygrupo")
    @GET
    @jakarta.ws.rs.Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Grupo> findByGrupo(@QueryParam("grupo")String grupo){
        return grupoRepository.findByGrupo(grupo).collect(toList());
    }
}
