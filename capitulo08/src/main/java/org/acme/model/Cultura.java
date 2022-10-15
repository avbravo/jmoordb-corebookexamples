/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.JakartaSource;

/**
 *
 * @author avbravo
 */
@Entity(jakartaSource = JakartaSource.JAVAEE_LEGACY)
public class Cultura {
    @Id
  private  String idcultura;
    @Column
   private String cultura;

    public Cultura() {
    }

    public Cultura(String idcultura, String cultura) {
        this.idcultura = idcultura;
        this.cultura = cultura;
    }

    public String getIdcultura() {
        return idcultura;
    }

    public void setIdcultura(String idcultura) {
        this.idcultura = idcultura;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }
    
    
    
}
