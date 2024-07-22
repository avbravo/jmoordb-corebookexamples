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
public class Numero {
    @Id(strategy = GenerationType.NONE)
    private Long idnumero;
    @Column
    private String numero;
    
    @Column
    private ObjectId _id;

    public Numero() {
    }

    public Numero(Long idnumero, String numero, ObjectId _id) {
        this.idnumero = idnumero;
        this.numero = numero;
        this._id = _id;
    }

    public Long getIdnumero() {
        return idnumero;
    }

    public void setIdnumero(Long idnumero) {
        this.idnumero = idnumero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

  
  

  
    
    
    
}
