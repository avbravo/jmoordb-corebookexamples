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
public class Corregimiento {

    @Id
    private String idcorregimiento;
    @Column
    private String corregimiento;
    @Referenced(from = "provincia", localField = "provincia.idprovincia", foreignField = "idprovincia", as = "provincia")
    private Provincia provincia;

    public Corregimiento() {
    }

    public String getIdcorregimiento() {
        return idcorregimiento;
    }

    public void setIdcorregimiento(String idcorregimiento) {
        this.idcorregimiento = idcorregimiento;
    }

    public String getCorregimiento() {
        return corregimiento;
    }

    public void setCorregimiento(String corregimiento) {
        this.corregimiento = corregimiento;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

}
