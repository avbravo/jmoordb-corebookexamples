/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.capitulo18.model;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;


/**
 *
 * @author avbravo
 */
@Entity(value = "estudiante")
public class Estudiante {

    @Id("idestudiante")
    private String idestudiante;
    @Column
    private String nombre;

    @Column
    private Integer edad;

    public Estudiante() {
    }

    public Estudiante(String idestudiante, String nombre, Integer edad) {
        this.idestudiante = idestudiante;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(String idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "idestudiante=" + idestudiante + ", nombre=" + nombre + ", edad=" + edad + '}';
    }

   
    
    
    

}
