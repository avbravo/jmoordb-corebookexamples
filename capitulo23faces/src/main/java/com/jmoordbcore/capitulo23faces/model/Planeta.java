/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;

/**
 *
 * @author avbravo
 */
@Entity(jakartaSource = JakartaSource.JAKARTA)
public class Planeta {

    @Column
    private String nombre;
    
   @Referenced(from="oceano", localField = "idoceano",typeReferenced = TypeReferenced.REFERENCED)
    private Oceano oceano;

@Embedded 
private Universo universo;

    public Planeta() {
    }

    public Planeta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Universo getUniverso() {
        return universo;
    }

    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

   
    public Oceano getOceano() {
        return oceano;
    }

    public void setOceano(Oceano oceano) {
        this.oceano = oceano;
    }
    
    
    
}
