/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.eclipse.jakarta.hello.faces;

import com.avbravo.jmoordbutils.FacesUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jakarta.hello.model.Estudiante;
import org.eclipse.jakarta.hello.restclient.EstudianteRestClient;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
public class EstudianteFaces implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    EstudianteRestClient estudianteRestClient;

    List<Estudiante> estudianteList = new ArrayList<>();

    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @PostConstruct
    public void init() {
        try {
            estudianteList = estudianteRestClient.findAll();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

}
