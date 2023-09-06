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
public record Estudiante (@Id("idestudiante")String idestudiante, @Column String nombre, @Column  Integer edad){
    

}
