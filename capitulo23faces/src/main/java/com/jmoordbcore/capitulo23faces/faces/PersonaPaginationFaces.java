/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.faces;

import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.util.JmoordbCorePageUtil;
import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcore.capitulo23faces.datamodel.PersonaDataModel;
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
public class PersonaPaginationFaces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    PersonaRepository personaRepository;

    private PersonaDataModel personaDataModel = new PersonaDataModel();
    List<Persona> personaList = new ArrayList<>();

    /**
     * Creates a new instance of PersonaFaces
     */
    public PersonaPaginationFaces() {

    }

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {
        findAllPagination();
    }
// </editor-fold>

  
    public String findAllPagination() {
        try {
            Long count = personaRepository.count();

            Integer numberOfPage = JmoordbCorePageUtil.numberOfPages(JmoordbCoreUtil.longToInteger(count), 25);

            System.out.println("Number OfPage  "+numberOfPage);

            Pagination pagination = new Pagination(1, 25);

//            pagination = JmoordbCorePageUtil.first(pagination);
//            pagination = JmoordbCorePageUtil.last(pagination);
//            pagination = JmoordbCorePageUtil.next(pagination);
//            pagination = JmoordbCorePageUtil.back(pagination);
//            personaList = personaRepository.findAll();

            move(pagination);
          
        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }

        return "";
    }

    
    public String move(Pagination pagination){
          personaList = personaRepository.findAllPagination(pagination);
            if (personaList == null) {
                System.out.println(">>>> No hay registros......");
            } else {
                
                   personaDataModel = new PersonaDataModel(personaList);
                System.out.println("Hay registros.......");
                for (Persona p : personaList) {
                    System.out.println("p.getNombre():  " + p.getNombre() + " p.getIdpersona(): " + p.getIdpersona());
                }
            }
            return "";
    }
}
