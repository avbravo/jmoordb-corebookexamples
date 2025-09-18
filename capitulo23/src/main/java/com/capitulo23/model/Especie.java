/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.capitulo23.model;

import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.faces.CoreConverter;

/**
 *
 * @author avbravo
 */
@Entity
@CoreConverter
public record Especie(String id, String name) {

}
