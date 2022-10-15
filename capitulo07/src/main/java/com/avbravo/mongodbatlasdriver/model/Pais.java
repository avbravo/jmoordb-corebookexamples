/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Entity
public class Pais {

    @Id
    private String idpais;
    @Column
    private String pais;
    @Embedded
    private Idioma idioma;
    
    @Embedded
    private List<Musica> musica;
    @Referenced(from = "planeta",localField = "planeta.idplaneta",foreignField = "idplaneta",as ="planeta", typePK = TypePK.STRING)
    private Planeta planeta;
    @Referenced(from = "oceano",localField = "oceano.idoceano",foreignField = "idoceano",as ="oceano")
    private List<Oceano> oceano;

    
    
    public Pais() {
    }

    public String getIdpais() {
        return idpais;
    }

    public void setIdpais(String idpais) {
        this.idpais = idpais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

//    public Planeta getPlaneta() {
//        return planeta;
//    }
//
//    public void setPlaneta(Planeta planeta) {
//        this.planeta = planeta;
//    }
    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public List<Musica> getMusica() {
        return musica;
    }

    public void setMusica(List<Musica> musica) {
        this.musica = musica;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public List<Oceano> getOceano() {
        return oceano;
    }

    public void setOceano(List<Oceano> oceano) {
        this.oceano = oceano;
    }

    
    
}
