/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.DocumentEmbeddable;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;

/**
 *
 * @author avbravo
 */
@DocumentEmbeddable(jakartaSource = JakartaSource.JAKARTA)
public class Especie {

    @Column
    private String nombre;
    
   @Referenced(from="oceano", localField = "idoceano",typeReferenced = TypeReferenced.REFERENCED)
    private Oceano oceano;


    public Especie() {
    }

    public Especie(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especie(String nombre, Oceano oceano) {
        this.nombre = nombre;
        this.oceano = oceano;
    }

    public Oceano getOceano() {
        return oceano;
    }

    public void setOceano(Oceano oceano) {
        this.oceano = oceano;
    }
    
    
    
}
