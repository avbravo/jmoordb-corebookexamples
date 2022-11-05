/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.DocumentEmbeddable;
import com.jmoordb.core.annotation.enumerations.JakartaSource;

/**
 *
 * @author avbravo
 */
@DocumentEmbeddable(jakartaSource = JakartaSource.JAKARTA)
public class Deporte {
    @Column
    private String deporte;
    
 
    public Deporte() {
    }

  

    
    
    public Deporte(String deporte) {
        this.deporte = deporte;
    }

    

    
    
    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deporte{");
        sb.append("deporte=").append(deporte);
        sb.append('}');
        return sb.toString();
    }

    
    
    
}
