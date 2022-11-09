/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jakartasetverfaces40.model;

/**
 *
 * @author avbravo
 */
public class Oceano {
    
    private String oceano;
        private String idoceano;

    public Oceano() {
    }

    public Oceano(String idoceano, String oceano) {
        this.oceano = oceano;
        this.idoceano = idoceano;
    }

        
        

    /**
     * Get the value of oceano
     *
     * @return the value of oceano
     */
    public String getOceano() {
        return oceano;
    }

    /**
     * Set the value of oceano
     *
     * @param oceano new value of oceano
     */
    public void setOceano(String oceano) {
        this.oceano = oceano;
    }



    /**
     * Get the value of idoceano
     *
     * @return the value of idoceano
     */
    public String getIdoceano() {
        return idoceano;
    }

    /**
     * Set the value of idoceano
     *
     * @param idoceano new value of idoceano
     */
    public void setIdoceano(String idoceano) {
        this.idoceano = idoceano;
    }

}
