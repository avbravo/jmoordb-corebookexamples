/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo18.controller;

/**
 *
 * @author avbravo
 */
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/helloarquillian")
@RequestScoped
public class HelloArquillianBean {
    @GET
    public String helloArquillian() {
        return "Hello Arquillian!";
    }
}
