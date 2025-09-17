/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.capitulo23.clases;

import com.jmoordb.core.annotation.builder.CoreBuilder;

/**
 *
 * @author avbravo
 */
@CoreBuilder
//@EntityRepository
public class Car {

    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    
  

   

}
