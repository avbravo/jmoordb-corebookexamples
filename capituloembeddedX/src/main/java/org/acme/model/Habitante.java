/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.model;

import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import java.util.Set;

/**
 *
 * @author avbravo
 */
@Entity(jakartaSource = JakartaSource.JAVAEE_LEGACY)
public class Habitante {
    @Id
    private String idhabitante;

    @Embedded
   Set<Persona> persona;
    
    @Embedded
    Idioma idioma;
    
    @Referenced(from = "pais", localField = "idpais",typeReferenced = TypeReferenced.REFERENCED)
    Set<Pais> pais;

    public Habitante() {
    }

    public Habitante(String idhabitante, Set<Persona> persona, Idioma idioma, Set<Pais> pais) {
        this.idhabitante = idhabitante;
        this.persona = persona;
        this.idioma = idioma;
        this.pais = pais;
    }

   

    public String getIdhabitante() {
        return idhabitante;
    }

    public void setIdhabitante(String idhabitante) {
        this.idhabitante = idhabitante;
    }

    public Set<Persona> getPersona() {
        return persona;
    }

    public void setPersona(Set<Persona> persona) {
        this.persona = persona;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Set<Pais> getPais() {
        return pais;
    }

    public void setPais(Set<Pais> pais) {
        this.pais = pais;
    }
   
    
}
