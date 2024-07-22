/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import jakarta.persistence.GenerationType;
import java.util.List;

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
    
    @Referenced(from = "oceano", localField = "idoceano",typeReferenced = TypeReferenced.REFERENCED)
    private List<Oceano> oceano;

    public Planeta() {
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

    public List<Oceano> getOceano() {
        return oceano;
    }

    public void setOceano(List<Oceano> oceano) {
        this.oceano = oceano;
    }
    
    
}
