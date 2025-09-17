/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo23.clases;

import com.avbravo.jmoordbcorecomponent.annotationprocessing.EntityRepository;
import com.jmoordb.core.annotation.builder.CoreBuilder;

/**
 *
 * @author avbravo
 */
@EntityRepository
@CoreBuilder
public class People {

    private Long id;
    private String name;

//    public People() {
//    }
//
//    
//    
//    public People(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
