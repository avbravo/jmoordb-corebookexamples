/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Grupoprofesion;
import com.avbravo.mongodbatlasdriver.model.Profesion;
import com.avbravo.mongodbatlasdriver.supplier.services.GrupoProfesionSupplierServices;
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
public class ProfesionSupplier implements Serializable{
       // <editor-fold defaultstate="collapsed" desc="graphics">

    /**
     * Profesion{
     *
     * @Referenced Grupopresion{ } }
     */
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
GrupoProfesionSupplierServices grupoprofesionSupplierServices;
    
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Profesion get(Supplier<? extends Profesion> s, Document document)">

    public  Profesion get(Supplier<? extends Profesion> s, Document document) {
        Profesion profesion = s.get();
        try {
            

            profesion.setIdprofesion(Integer.parseInt(String.valueOf(document.get("idprofesion"))));
            profesion.setProfesion(String.valueOf(document.get("profesion")));

            Referenced grupoprofesionReferenced = new Referenced() {
                @Override
                public String from() {
                    return "grupoprofesion";
                }

                @Override
                public String localField() {
                    return "grupoprofesion.idgrupoprofesion";
                }

                @Override
                public String foreignField() {
                    return "idgrupoprofesion";
                }

                @Override
                public String as() {
                    return "grupoprofesion";
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
            Boolean istListReferecendToGrupoprofesion = false;
            if (!istListReferecendToGrupoprofesion) {
                Optional<Grupoprofesion> grupoprofesionOptional = grupoprofesionSupplierServices.findByPK(document, grupoprofesionReferenced);
                if (grupoprofesionOptional.isPresent()) {
                   profesion.setGrupoprofesion(grupoprofesionOptional.get());
                } else {
                    MessagesUtil.warning("No tiene referencia a Grupoprofesion");
                }
            } else {

                /**
                 * Pasos para @Referenced List<>
                 * 1- Obtener la lista documento 2- Obtener un List<SDocument>
                 * de las llaves primarias
                 */
               
                List<Grupoprofesion> grupoprofesionList =grupoprofesionSupplierServices.findAllByPK(document, grupoprofesionReferenced);
               
              //profesion.setGrupoprofesion(grupoprofesionList);
            }

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return profesion;

    }
// </editor-fold>
   
    
    
}
