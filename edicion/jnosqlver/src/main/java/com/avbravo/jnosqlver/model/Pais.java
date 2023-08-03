/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jnosqlver.model;



import java.util.Date;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
//import jakarta.nosql.Entity;
import jakarta.nosql.Id;
/**
 *
 * @author avbravo
 */
@Entity
public record Pais( @Id Long idpais,@Column String pais, @Column Date fecha) {
    
}
