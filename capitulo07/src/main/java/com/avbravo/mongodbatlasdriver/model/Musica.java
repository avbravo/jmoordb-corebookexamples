/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.model;

import com.jmoordb.core.annotation.DocumentEmbeddable;



/**
 *
 * @author avbravo
 */
@DocumentEmbeddable
public class Musica {

   private String idmusica;
   private String musica;

    public Musica() {
    }

    public String getIdmusica() {
        return idmusica;
    }

    public void setIdmusica(String idmusica) {
        this.idmusica = idmusica;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    
   
    
}
