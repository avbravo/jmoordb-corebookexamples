/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.model;

import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Jugador {
    @Id(strategy = GenerationType.AUTO)
    private Long idjugador;
    @Embedded
    Persona persona;
    @Referenced(from = "equipo",localField = "uid")
    Equipo equipo;

    public Jugador() {
    }

    public Jugador(Long idjugador, Persona persona, Equipo equipo) {
        this.idjugador = idjugador;
        this.persona = persona;
        this.equipo = equipo;
    }

    public Long getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(Long idjugador) {
        this.idjugador = idjugador;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" + "idjugador=" + idjugador + ", persona=" + persona + ", equipo=" + equipo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idjugador);
        hash = 71 * hash + Objects.hashCode(this.persona);
        hash = 71 * hash + Objects.hashCode(this.equipo);
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
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.idjugador, other.idjugador)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        return Objects.equals(this.equipo, other.equipo);
    }
    
    
    
    
}
