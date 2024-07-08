/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo19.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Empresa {
    @Id 
    private Long idempresa;
    @Column
    private String empresa;
  

    public Empresa() {
    }

    public Empresa(Long idempresa, String empresa) {
        this.idempresa = idempresa;
        this.empresa = empresa;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idempresa);
        hash = 67 * hash + Objects.hashCode(this.empresa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        return Objects.equals(this.idempresa, other.idempresa);
    }

    @Override
    public String toString() {
        return "Empresa{" + "idempresa=" + idempresa + ", empresa=" + empresa + '}';
    }

   
  
    
    
}
