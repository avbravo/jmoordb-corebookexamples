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
public class Pais {
    @Id
    private Long idpais;
    @Column
    private String pais;

    public Pais() {
    }

    public Pais(Long idpais, String pais) {
        this.idpais = idpais;
        this.pais = pais;
    }

    public Long getIdpais() {
        return idpais;
    }

    public void setIdpais(Long idpais) {
        this.idpais = idpais;
    }

   
 
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pais{");
        sb.append("idpais=").append(idpais);
        sb.append(", pais=").append(pais);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
