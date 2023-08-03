/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

/**
 *
 * @author avbravo
 */
@Path("oceano")
public class OceanoController {
//  @Inject
//  OceanoRepository oceanoRepository;
    
//      @Inject
//    public OceanoController (OceanoRepository oceanoRepository) {
//        this.oceanoRepository = oceanoRepository;
//        
//    }

    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Oceano> findAll(){
//        return oceanoRepository.findAll();
//    }
    
     @GET
    public String getHello(@QueryParam("idoceano") @DefaultValue("idoceano") String idoceano) {
         System.out.println("________________________________________________________________"); 
        System.out.println("OceanoController.java");
        return "Oceano Pacifico";
//        Optional<Oceano> oceano =oceanoRepository.findByPk(idoceano);
//        if(oceano.isPresent()){
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>< encontado");
//            return oceano.get().getOceano();
//        }
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>< No fue encontado");
//        return "No existe oceano con ese id";

    }
}
