/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.bingo.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;

/**
 *
 * @author avbravo
 */
@Entity
public class Numero {
    @Id
    private String idnumero;
    @Column
    private Integer numero;
    @Column
    private String image;
    @Column
    private String jugado;

    public Numero() {
    }

    public Numero(String idnumero, Integer numero, String image, String jugado) {
        this.idnumero = idnumero;
        this.numero = numero;
        this.image = image;
        this.jugado = jugado;
    }

    public String getIdnumero() {
        return idnumero;
    }

    public void setIdnumero(String idnumero) {
        this.idnumero = idnumero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJugado() {
        return jugado;
    }

    public void setJugado(String jugado) {
        this.jugado = jugado;
    }
    
    
    
    
}
