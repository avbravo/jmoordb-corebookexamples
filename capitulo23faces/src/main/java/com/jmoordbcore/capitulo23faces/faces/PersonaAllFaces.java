/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.faces;

import com.avbravo.jmoordbutils.paginator.Paginator;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.util.JmoordbCorePageUtil;
import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcore.capitulo23faces.model.Persona;
import com.jmoordbcore.capitulo23faces.repository.PersonaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author avbravo
 */
@Named()
@ViewScoped
@Data
public class PersonaAllFaces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    PersonaRepository personaRepository;

    List<Persona> personaList = new ArrayList<>();

    /**
     * Creates a new instance of PersonaFaces
     */
    public PersonaAllFaces() {

    }

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {
        findAll();
    }
// </editor-fold>

    public String findAll() {
        try {

            personaList = personaRepository.findAll();

         
        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }

        return "";
    }
   
}
