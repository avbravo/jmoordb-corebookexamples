/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo10.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Entity()
public class Persona {

    @Id
    private String email;
    @Column
    private String nombre;


    @Embedded
    List<Deportes> deportes;

    public Persona() {
    }

    public Persona(String email, String nombre, List<Deportes> deportes) {
        this.email = email;
        this.nombre = nombre;
        this.deportes = deportes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Deportes> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deportes> deportes) {
        this.deportes = deportes;
    }

   
    

}
