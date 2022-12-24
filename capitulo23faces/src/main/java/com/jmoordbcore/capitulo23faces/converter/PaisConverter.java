/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmoordbcore.capitulo23faces.converter;


import com.jmoordbcore.capitulo23faces.model.Pais;
import com.jmoordbcore.capitulo23faces.repository.PaisRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@RequestScoped
@Named
public class PaisConverter implements Converter {
    @Inject
    PaisRepository paisRepository;
  @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        try {
           if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Pais) {
          return String.valueOf(((Pais) modelValue).getIdpais());
        } else {
            System.out.println("----------->getAsString");
          throw new ConverterException(new FacesMessage(modelValue + " is not a valid from Converter"));
        }
      } catch (Exception e) {
            System.out.println("--------getAsString () "+e.getLocalizedMessage());
            new FacesMessage("Error en converter Pais "+e.getLocalizedMessage());
      }

 return "";
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        Pais a = new Pais();
        if (paisRepository == null) {
            System.out.println("Service is nich");
        }

        if (submittedValue == null || submittedValue.isEmpty()) {
            System.out.println("submitted = nil");
            return null;
        }

        try {
            Integer id=Integer.parseInt(submittedValue);
            Long idPais= id.longValue();
            Optional<Pais> optional = paisRepository.findByPk(idPais);
            if (optional.isPresent()) {
                a = optional.get();
            }
            return a;
        } catch (Exception e) {
            System.out.println("====================");
            System.out.println("---> getAsObject" +e.getLocalizedMessage());
            System.out.println("====================");
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
    }

}

