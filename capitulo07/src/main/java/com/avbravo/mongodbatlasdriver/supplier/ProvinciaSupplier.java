/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Pais;
import com.avbravo.mongodbatlasdriver.model.Provincia;
import com.avbravo.mongodbatlasdriver.supplier.services.PaisSupplierServices;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
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
public class ProvinciaSupplier implements Serializable{

            // <editor-fold defaultstate="collapsed" desc="graphics">

    /**
     *
     * Provincia{
     *
     * @Referenced Pais{
     * @Referenced Planeta
     * @Referenced Oceano
     * @Embedded Idioma idioma;
     * @Embedded List<Musica>; } }
     *
     */
// </editor-fold>
   // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    PaisSupplierServices paisSupplierServices;
   
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Provincia get(Supplier<? extends Provincia> s, Document document)">
    public Provincia get(Supplier<? extends Provincia> s, Document document) {
        Provincia provincia = s.get();
        try {

            /**
             * --------------------------------------------------------
             *
             * Step:0
             * <Attributes and @Embedded>
             * --------------------------------------------------------
             */
            provincia.setIdprovincia(String.valueOf(document.get("idprovincia")));
            provincia.setProvincia(String.valueOf(document.get("provincia")));

            /**
             * ---------------------------------------------
             *
             * @Embedded simple ----------------------------------------------
             */
           
            /**
             * --------------------------------------------------
             *
             * @Embedded List<>
             * Debe utilizar una lista temporal para almacenar los valores
             * --------------------------------------------------
             */
          

            /**
             * ------------------------------------------------
             *
             * Step 1:
             * <@Referemced>
             * Generar las interfaces Referenced Verificar si es List<> o una
             * Referencia simple Obtener el valor de la llave primaria mediatne
             * DocumentUtil.getIdValue(...)
             *
             */
           
            Referenced paisReferenced = new Referenced() {
                @Override
                public String from() {
                    return "pais";
                }

                @Override
                public String localField() {
                    return "pais.idpais";
                }

                @Override
                public String foreignField() {
                    return "idpais";
                }

                @Override
                public String as() {
                    return "pais";
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
            Boolean istListReferecendToPais = false;
            if (!istListReferecendToPais) {
                Optional<Pais> paisOptional = paisSupplierServices.findByPK(document, paisReferenced);
                if (paisOptional.isPresent()) {
                    provincia.setPais(paisOptional.get());
                } else {
                    MessagesUtil.warning("No tiene referencia a Planeta");
                }
            } else {

                /**
                 * Pasos para @Referenced List<>
                 * 1- Obtener la lista documento 2- Obtener un List<SDocument>
                 * de las llaves primarias
                 */
              
                List<Pais> paisList = paisSupplierServices.findAllByPK(document, paisReferenced);
              
              //provincia.setPais(paisList);
            }
           
           

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return provincia;

    }
// </editor-fold>

    
  

}
