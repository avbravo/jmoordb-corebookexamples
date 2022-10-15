/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;

/**
 *
 * @author avbravo
 */
@Entity
public class Persona {

    @Id
    private String idpersona;
    @Column
    private String nombre;
    @Referenced(from = "corregimiento", localField = "corregimiento.idcorregimiento", foreignField = "idcorregimiento", as = "corregimiento")
    private Corregimiento corregimiento;
    @Referenced(from = "profesion", localField = "profesion.idprofesion", foreignField = "idprofesion", as = "profesion")
    private Profesion profesion;

    public Persona() {
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Corregimiento getCorregimiento() {
        return corregimiento;
    }

    public void setCorregimiento(Corregimiento corregimiento) {
        this.corregimiento = corregimiento;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    

}
