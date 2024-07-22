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
public class Especialidad {
    @Id(strategy = GenerationType.NONE)
    private String idespecialidad;
    @Column
    private String especialidad;
    
    @Column
    private ObjectId _id;

    public Especialidad() {
    }

    public Especialidad(String idespecialidad, String especialidad, ObjectId _id) {
        this.idespecialidad = idespecialidad;
        this.especialidad = especialidad;
        this._id = _id;
    }

    public String getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(String idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "idespecialidad=" + idespecialidad + ", especialidad=" + especialidad + ", _id=" + _id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.idespecialidad);
        hash = 47 * hash + Objects.hashCode(this.especialidad);
        hash = 47 * hash + Objects.hashCode(this._id);
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
        final Especialidad other = (Especialidad) obj;
        if (!Objects.equals(this.idespecialidad, other.idespecialidad)) {
            return false;
        }
        if (!Objects.equals(this.especialidad, other.especialidad)) {
            return false;
        }
        return Objects.equals(this._id, other._id);
    }

  

  
    
    
    
}
