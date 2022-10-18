/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo02.controller;

/**
 *
 * @author avbravo
 */
public class Auto implements Vehiculo{

    @Override
    public void inicar() {
        saludo();
        saludo2();
    }
    
    @Override
    public void saludo(){
       saludo2();
    }

    @Override
    public void detener() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
