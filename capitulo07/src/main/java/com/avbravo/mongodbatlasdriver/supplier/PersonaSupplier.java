/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Persona;
import com.avbravo.mongodbatlasdriver.model.Corregimiento;
import com.avbravo.mongodbatlasdriver.model.Profesion;
import com.avbravo.mongodbatlasdriver.supplier.services.CorregimientoSupplierServices;
import com.avbravo.mongodbatlasdriver.supplier.services.ProfesionSupplierServices;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@RequestScoped
public class PersonaSupplier implements Serializable{

    // <editor-fold defaultstate="collapsed" desc="graphics">

    /**
     * Persona{
     *
     * @Referenced Corregimiento{
     * @Referenced Provincia{
     * @Referenced Pais{
     * @Referenced Corregimiento{}
     * @Referenced Oceano{}
     * @Embedded Idioma idioma;
     * @Embedded List<Musica>; } } }
     * @Referenced Profesion{
     * @Referenced Grupopresion{ } }
     */
// </editor-fold>
    
       // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    CorregimientoSupplierServices corregimientoSupplierServices;
    @Inject
    ProfesionSupplierServices profesionSupplierServices;
//    @Inject
//    ProfesionRepository profesionRepository;
   
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Persona get(Supplier<? extends Persona> s, Document document)">
    public  Persona get(Supplier<? extends Persona> s, Document document) {
        Persona persona = s.get();
        try {
         

            persona.setIdpersona(String.valueOf(document.get("idpersona")));
            persona.setNombre(String.valueOf(document.get("nombre")));
/**
 * Corregimiento
 */
            Referenced corregimientoReferenced = new Referenced() {
                @Override
                public String from() {
                    return "corregimiento";
                }

                @Override
                public String localField() {
                    return "corregimiento.idcorregimiento";
                }

                @Override
                public String foreignField() {
                    return "idcorregimiento";
                }

                @Override
                public String as() {
                    return "corregimiento";
                }

               @Override
                public TypeReferenced typeReferenced() {
                   return TypeReferenced.REFERENCED;
                }

                @Override
                public Class<? extends Annotation> annotationType() {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                 @Override
                public TypePK typePK() {
                    return TypePK.STRING;
                }
            };

            /**
             * Crear una variable del tipo y valor de Referenced.foreigndFiel()
             * Verificar el tipo keyString()
             *
             */
            Boolean istListReferecendToCorregimiento = false;
            if (!istListReferecendToCorregimiento) {
                Optional<Corregimiento> corregimientoOptional = corregimientoSupplierServices.findByPK(document, corregimientoReferenced);
                if (corregimientoOptional.isPresent()) {
                    persona.setCorregimiento(corregimientoOptional.get());
                } else {
                    MessagesUtil.warning("No tiene referencia a Corregimiento");
                }
            } else {

                List<Corregimiento> corregimientoList = corregimientoSupplierServices.findAllByPK(document, corregimientoReferenced);
              //persona.setCorregimiento(corregimientoList);
            }

            
            /**
             * Profesion
             */
              Referenced profesionReferenced = new Referenced() {
                @Override
                public String from() {
                    return "profesion";
                }

                @Override
                public String localField() {
                    return "profesion.idprofesion";
                }

                @Override
                public String foreignField() {
                    return "idprofesion";
                }

                @Override
                public String as() {
                    return "profesion";
                }

               @Override
                public TypeReferenced typeReferenced() {
                   return TypeReferenced.REFERENCED;
                }

                @Override
                public Class<? extends Annotation> annotationType() {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public TypePK typePK() {
                    return TypePK.STRING;
                }
            };

            /**
             * Crear una variable del tipo y valor de Referenced.foreigndFiel()
             * Verificar el tipo keyString()
             *
             */
            Boolean istListReferecendToProfesion = false;
            if (!istListReferecendToProfesion) {
                Optional<Profesion> profesionOptional = profesionSupplierServices.findByPK(document, profesionReferenced); 
                if (profesionOptional.isPresent()) {
                    persona.setProfesion(profesionOptional.get());
                } else {
                    MessagesUtil.warning("No tiene referencia a Corregimiento");
                }
            } else {


               List<Profesion> profesionList = profesionSupplierServices.findAllByPK(document, profesionReferenced);
              //persona.setProfesion(profesionList);
            }
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return persona;

    }
// </editor-fold>
    

}
