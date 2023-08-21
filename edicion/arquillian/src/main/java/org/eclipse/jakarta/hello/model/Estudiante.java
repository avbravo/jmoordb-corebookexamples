/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.eclipse.jakarta.hello.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Entity()
public class Estudiante {

    @Id
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

   
    
    
    

}
