/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;



/**
 *
 * @author avbravo
 */
@Entity
public class Grupoprofesion {
    
    @Id
    private String idgrupoprofesion;
    @Column
      private String grupoprofesion;

    public Grupoprofesion() {
    }

    public String getIdgrupoprofesion() {
        return idgrupoprofesion;
    }

    public void setIdgrupoprofesion(String idgrupoprofesion) {
        this.idgrupoprofesion = idgrupoprofesion;
    }

    public String getGrupoprofesion() {
        return grupoprofesion;
    }

    public void setGrupoprofesion(String grupoprofesion) {
        this.grupoprofesion = grupoprofesion;
    }

    
  

    
    
}
