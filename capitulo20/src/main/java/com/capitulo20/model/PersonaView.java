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
@ViewEntity(collection = "persona")
public class PersonaView {
    @Id(strategy = GenerationType.OBJECTID )
    private ObjectId _id;
    @Column
    private String nombre;

    public PersonaView() {
    }

    public PersonaView(ObjectId _id, String nombre) {
        this._id = _id;
        this.nombre = nombre;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getNombre() {
        return  nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this._id);
        hash = 79 * hash + Objects.hashCode(this.nombre);
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
        final PersonaView other = (PersonaView) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this._id, other._id);
    }

    @Override
    public String toString() {
        return "Persona{" + "_id=" + _id + ", nombre=" + nombre + '}';
    }
    

   
   
    
    
    
    
}