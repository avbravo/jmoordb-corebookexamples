/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import java.util.Date;



/**
 *
 * @author avbravo
 */
@Entity()
public class Oceano {

    @Id
    private String idoceano;
    @Column
    private String oceano;
    
    @Column
    private Date fecha;

    public Oceano() {
    }

    public Oceano(String idoceano, String oceano, Date fecha) {
        this.idoceano = idoceano;
        this.oceano = oceano;
        this.fecha = fecha;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    public String getIdoceano() {
        return idoceano;
    }

    public void setIdoceano(String idoceano) {
        this.idoceano = idoceano;
    }

    public String getOceano() {
        return oceano;
    }

    public void setOceano(String oceano) {
        this.oceano = oceano;
    }

    
    
    
    
}
