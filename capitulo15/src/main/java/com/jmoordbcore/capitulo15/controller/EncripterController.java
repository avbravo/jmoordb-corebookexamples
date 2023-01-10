/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo15.controller;

import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
import com.jmoordbcoreencripter.jmoordbencripter.JWTEncrypter;
import com.jmoordbcoreencripter.model.JWTEntity;
import com.jmoordbcoreencripter.model.JWTToken;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author avbravo
 */
@Path("encripter")
public class EncripterController {


    /**
     * Generar token Encripta
     * http://localhost:8080/capitulo15/api/encripter?subject=avbravo&&password=mipassword&&group=admin&&secretKey=MiClaveSecreta&&expirationDays=90
     *
     * Desencripta
     * http://localhost:8080/capitulo15/api/encripter/decript?secretKey=MiClaveSecreta&&token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdmJyYXZvIiwiYXVkIjpbImFkbWluIiwidUl4MGV1UlJEcGZFVURkK2Q3VzV4UT09Il0sImlzcyI6ImF2YnJhdm8uYmxvZ3Bvc3QuY29tIiwiZXhwIjoxNjgxMDc5MTY0LCJpYXQiOjE2NzMzMDMxNjQsImp0aSI6Ijk5OGI5YzgyLTFlY2MtNDZlYS05ODUxLWFkOTk1YThjMWUzOCJ9.rgL_ttvweBHI356riZkAUd1D3JD4Gqo30aghXTm36qY
     *
     * Ver JWT https://jwt.io/
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public JWTToken encripter(@QueryParam("subject") final String subject,
            @QueryParam("password") final String password,
            @QueryParam("group") final String group,
            @QueryParam("expirationDays") final int expirationDays,
            @QueryParam("secretKey") final String secretKey
    ) {
        JWTToken jWTToken = new JWTToken();
        String token = "";
        try {

            String encryptedString = Encryptor.encrypt(password, secretKey);

            JWTEntity jWTEntity = new JWTEntity.Builder()
                    .subject(subject)// vacio o el nombre del subject
                    .group(group) // vacio o el nombre de grupo
                    .password(encryptedString) // password
                    .expirationDays(expirationDays) // tiempo de expiracion en dias 90
                    .secretKey(secretKey) // llave secreta
                    .build();

            token = JWTEncrypter.encrypt(jWTEntity);

            jWTToken.setToken(token);

       

        } catch (Exception ex) {
            Logger.getLogger(EncripterController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jWTToken;

    }

    /**
     * Consultar el token
     * http://localhost:8080/capitulo15/api/encripter/decript?secretKey=SAas&token=
     *
     * @param token
     * @param secretKey
     * @return
     */
    // <editor-fold defaultstate="collapsed" desc="  @Path("insert")">
    @Path("decript")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public JWTEntity decript(@QueryParam("token") final String token,
            @QueryParam("secretKey") final String secretKey) {

        JWTEntity jWTEntity = new JWTEntity();
        try {
    
            jWTEntity = JWTEncrypter.decrypt(token, secretKey);
           
            String decryptedString = Encryptor.decrypt(jWTEntity.getPassword(), secretKey);

           
            jWTEntity.setPassword(decryptedString);

           
        } catch (Exception e) {
            System.out.println("decript() " + e.getLocalizedMessage());
        }

        return jWTEntity;
    }
// </editor-fold>
}
