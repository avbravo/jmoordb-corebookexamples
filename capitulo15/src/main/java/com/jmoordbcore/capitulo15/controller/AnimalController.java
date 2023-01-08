/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo15.controller;

import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcore.capitulo15.model.Animal;
import com.jmoordbcore.capitulo15.model.Pais;
import com.jmoordbcore.capitulo15.repository.AnimalRepository;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
import com.jmoordbcoreencripter.jmoordbencripter.JWTInfo;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        try {

            //Create the token from user details.
            /**
             * Funciona para cifrar pàssword con fecha de caducidad en base a un JWT
             */
            int EXPIRY_DAYS =90;
            Integer STATUS =0;
            String USER ="avbravo";
            String PASSWORD="s7_$4wnT1den4=/pana1e1";
            String SECRET_KEY="mi llave secreta para JWT";
            String GROUP="admin";
          String token =  Encryptor.encryptJWT(EXPIRY_DAYS, STATUS, GROUP, 
                 PASSWORD, USER,SECRET_KEY);
          
            System.out.println("[Token encriptado ] "+token);
            
         JWTInfo jWTInfo = Encryptor.decryptJWT(token,SECRET_KEY);
            System.out.println("[Desencriptado]");
            System.out.println("jWTInfo.getGroup()"+jWTInfo.getGroup());
            System.out.println("jWTInfo.getPassword()"+jWTInfo.getPassword());
            System.out.println("jWTInfo.getSubject()"+jWTInfo.getSubject());
            System.out.println("jWTInfo.getIsValid())"+jWTInfo.getIsValid());
            
            
            
         
//            
//            
        } catch (Exception ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return animalRepository.findAll();

    }

    // <editor-fold defaultstate="collapsed" desc="  @Path("insert")">
    @Path("insert")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Pais> insert(@QueryParam("inicial") final Integer inicial) {

        Integer limiteFactor = 13545;

        Integer maximo = inicial + limiteFactor;
        for (int i = inicial; i <= maximo; i++) {

            Pais pais = new Pais();
            pais.setIdpais(JmoordbCoreUtil.integerToLong(i));
            pais.setPais("Pais - " + pais.getIdpais());
            pais.setFecha(new Date());
            // paisRepository.save(pais);
        }
        return new ArrayList<>();
    }
// </editor-fold>
}
