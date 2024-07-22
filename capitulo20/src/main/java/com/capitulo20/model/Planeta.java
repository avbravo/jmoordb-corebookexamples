/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author avbravo
 */
@Entity
public class Planeta {
    @Id(strategy = GenerationType.AUTO)
    private Long idplaneta;
    @Column
    private String planeta;
    


    public Planeta() {
    }

    public Planeta(Long idplaneta, String planeta) {
        this.idplaneta = idplaneta;
        this.planeta = planeta;
    }

    public Long getIdplaneta() {
        return idplaneta;
    }

    public void setIdplaneta(Long idplaneta) {
        this.idplaneta = idplaneta;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    
   
    
    
    
}
