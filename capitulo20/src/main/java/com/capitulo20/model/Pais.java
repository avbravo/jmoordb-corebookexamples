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
public class Pais {
    @Id(strategy = GenerationType.AUTO)
    private Long idpais;
    @Column
    private String pais;
    
    @Column
    private ObjectId _id;

    public Pais() {
    }

    public Pais(Long idpais, String pais, ObjectId _id) {
        this.idpais = idpais;
        this.pais = pais;
        this._id = _id;
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

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Pais{" + "idpais=" + idpais + ", pais=" + pais + ", _id=" + _id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idpais);
        hash = 17 * hash + Objects.hashCode(this.pais);
        hash = 17 * hash + Objects.hashCode(this._id);
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.idpais, other.idpais)) {
            return false;
        }
        return Objects.equals(this._id, other._id);
    }

  
    
    
    
}
