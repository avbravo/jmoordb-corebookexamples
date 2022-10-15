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
public class Idioma {

   private String ididioma;
   private String idioma;

    public Idioma() {
    }

    public String getIdidioma() {
        return ididioma;
    }

    public void setIdidioma(String ididioma) {
        this.ididioma = ididioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
   
   
    
}
