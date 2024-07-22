/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo08.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import java.util.Date;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Entity(jakartaSource = JakartaSource.JAKARTA)
public class Animal {
   @Id(strategy = GenerationType.AUTO)
 private Long idanimal;
 @Column
 private String animal;
 @Column
 private String color;
 @Column 
 private Long edad;
 @Column
 private Date fechaalimentacion;
 
 @Embedded
 private Alimentacion alimentacion;
 
 @Embedded
 private List<Enfermedad> enfermedad;
 
 @Referenced(from = "grupo",localField = "idgrupo",typeReferenced = TypeReferenced.REFERENCED)
 private Grupo grupo;

 @Referenced(from="zoo",localField = "idzoo",typeReferenced = TypeReferenced.REFERENCED)
 private List<Zoo> zoo;
 
 
 

    public Animal() {
    }

    public Animal(Long idanimal, String animal, String color, Long edad, Date fechaalimentacion, Alimentacion alimentacion, List<Enfermedad> enfermedad, Grupo grupo, List<Zoo> zoo) {
        this.idanimal = idanimal;
        this.animal = animal;
        this.color = color;
        this.edad = edad;
        this.fechaalimentacion = fechaalimentacion;
        this.alimentacion = alimentacion;
        this.enfermedad = enfermedad;
        this.grupo = grupo;
        this.zoo = zoo;
    }

    public Long getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(Long idanimal) {
        this.idanimal = idanimal;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public Date getFechaalimentacion() {
        return fechaalimentacion;
    }

    public void setFechaalimentacion(Date fechaalimentacion) {
        this.fechaalimentacion = fechaalimentacion;
    }

    public Alimentacion getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(Alimentacion alimentacion) {
        this.alimentacion = alimentacion;
    }

    public List<Enfermedad> getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(List<Enfermedad> enfermedad) {
        this.enfermedad = enfermedad;
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

   
    
 
 
 
}
