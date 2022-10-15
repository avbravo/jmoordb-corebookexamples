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
public class Planeta {
    
    @Id
    private String idplaneta;
    @Column
      private String planeta;

    public Planeta() {
    }

    
  

    
    
    public String getIdplaneta() {
        return idplaneta;
    }

    public void setIdplaneta(String idplaneta) {
        this.idplaneta = idplaneta;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }
    
    
    
}
