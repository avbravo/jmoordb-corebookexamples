/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.JakartaSource;

/**
 *
 * @author avbravo
 */
@Entity(jakartaSource = JakartaSource.JAKARTA)
public class Zoo {
    @Id
    private String idzoo;
    
    @Column
    private String nombre;

    public Zoo() {
    }

    public String getIdzoo() {
        return idzoo;
    }

    public void setIdzoo(String idzoo) {
        this.idzoo = idzoo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
