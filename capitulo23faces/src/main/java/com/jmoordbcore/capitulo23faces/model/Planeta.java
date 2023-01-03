/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Entity(jakartaSource = JakartaSource.JAKARTA)
public class Planeta {

    @Id
    private String idplaneta;
    @Column
    private String planeta;

//   @Referenced(from="oceano", localField = "idoceano",typeReferenced = TypeReferenced.REFERENCED)
//    private Oceano oceano;
    @Embedded
    private List<Universo> universo;
    @Embedded
    private List<Especie> especie;

    
    
     @Referenced(from = "grupo",localField = "idgrupo",typeReferenced = TypeReferenced.REFERENCED)
 private Grupo grupo;
     
     
      @Referenced(from="zoo",localField = "idzoo",typeReferenced = TypeReferenced.REFERENCED)
 private List<Zoo> zoo;
      
    public Planeta() {
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Zoo> getZoo() {
        return zoo;
    }

    public void setZoo(List<Zoo> zoo) {
        this.zoo = zoo;
    }

    
    
    
    public String getIdplaneta() {
        return idplaneta;
    }

    public void setIdplaneta(String idplaneta) {
        this.idplaneta = idplaneta;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public List<Universo> getUniverso() {
        return universo;
    }

    public void setUniverso(List<Universo> universo) {
        this.universo = universo;
    }

    public List<Especie> getEspecie() {
        return especie;
    }

    public void setEspecie(List<Especie> especie) {
        this.especie = especie;
    }

}
