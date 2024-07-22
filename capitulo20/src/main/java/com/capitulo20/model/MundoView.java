/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.ViewEntity;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author avbravo
 */
@ViewEntity(collection = "mundo")
public class MundoView {
    @Id(strategy = GenerationType.AUTO)
    private Long idmundo;
    @Column
    private String mundo;
    
    @Column
    private ObjectId _id;

    public MundoView() {
    }

    public MundoView(Long idmundo, String mundo, ObjectId _id) {
        this.idmundo = idmundo;
        this.mundo = mundo;
        this._id = _id;
    }

    public Long getIdmundo() {
        return idmundo;
    }

    public void setIdmundo(Long idmundo) {
        this.idmundo = idmundo;
    }

    public String getMundo() {
        return mundo;
    }

    public void setMundo(String mundo) {
        this.mundo = mundo;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

   
    
    
    
}
