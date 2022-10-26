/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.DocumentEmbeddable;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.JakartaSource;


/**
 *
 * @author avbravo
 */
@DocumentEmbeddable(jakartaSource = JakartaSource.JAVAEE_LEGACY )
public class Idioma {
       @Id
       private String ididioma;
       @Column
       private String idioma;
       @Referenced(from = "cultura", localField = "idcultura")
       private Cultura cultura;

    public Idioma() {
    }

    public Idioma(String ididioma, String idioma, Cultura cultura) {
        this.ididioma = ididioma;
        this.idioma = idioma;
        this.cultura = cultura;
    }

    
    
    public Cultura getCultura() {
        return cultura;
    }

    public void setCultura(Cultura cultura) {
        this.cultura = cultura;
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
