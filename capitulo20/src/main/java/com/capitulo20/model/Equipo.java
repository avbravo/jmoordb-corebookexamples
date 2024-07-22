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
import java.util.UUID;

/**
 *
 * @author avbravo
 */
@Entity
public class Equipo {

    @Id(strategy = GenerationType.UUID)
    UUID uid;
    @Column
    private String equipo;

    public Equipo() {
    }

    public Equipo(UUID uid, String equipo) {
        this.uid = uid;
        this.equipo = equipo;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.uid);
        hash = 97 * hash + Objects.hashCode(this.equipo);
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
        final Equipo other = (Equipo) obj;
        if (!Objects.equals(this.equipo, other.equipo)) {
            return false;
        }
        return Objects.equals(this.uid, other.uid);
    }

    @Override
    public String toString() {
        return "Equipo{" + "uid=" + uid + ", equipo=" + equipo + '}';
    }

}
