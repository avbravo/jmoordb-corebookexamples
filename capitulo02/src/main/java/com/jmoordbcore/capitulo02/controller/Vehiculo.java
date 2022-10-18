/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo02.controller;

/**
 *
 * @author avbravo
 */
public interface Vehiculo {
    void inicar();
    void detener();
    default void saludo(){
        System.out.println("Hola mundo");
    }
    default void saludo2(){
        System.out.println("Hola mundo");
    }
}
