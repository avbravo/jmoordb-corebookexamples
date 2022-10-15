/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Corregimiento;
import com.avbravo.mongodbatlasdriver.model.Provincia;
import com.avbravo.mongodbatlasdriver.supplier.services.ProvinciaSupplierServices;
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
public class CorregimientoSupplier implements Serializable {

    // <editor-fold defaultstate="collapsed" desc="grephics">
    /**
     *
     * Corregimiento{
     *
     * @Referenced Provincia{
     * @Referenced Pais{
     * @Referenced Planeta
     * @Referenced Oceano
     * @Embedded Idioma idioma;
     * @Embedded List<Musica>; } } }
     *
     *
     */
    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    ProvinciaSupplierServices provinciaSupplierServices;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Provincia get(Supplier<? extends Provincia> s, Document document)">
    public Corregimiento get(Supplier<? extends Corregimiento> s, Document document) {
        Corregimiento corregimiento = s.get();
        try {

            /**
             * --------------------------------------------------------
             *
             * Step:0
             * <Attributes and @Embedded>
             * --------------------------------------------------------
             */
            corregimiento.setIdcorregimiento(String.valueOf(document.get("idcorregimiento")));
            corregimiento.setCorregimiento(String.valueOf(document.get("corregimiento")));

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
            Referenced provinciaReferenced = new Referenced() {
                @Override
                public String from() {
                    return "provincia";
                }

                @Override
                public String localField() {
                    return "provincia.idprovincia";
                }

                @Override
                public String foreignField() {
                    return "idprovincia";
                }

                @Override
                public String as() {
                    return "provincia";
                }

              
                @Override
                public Class<? extends Annotation> annotationType() {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public TypePK typePK() {
                    return TypePK.STRING;
                }

                @Override
                public TypeReferenced typeReferenced() {
                   return TypeReferenced.REFERENCED;
                }

               
            };

            /**
             * Crear una variable del tipo y valor de Referenced.foreigndFiel()
             * Verificar el tipo keyString()
             *
             */
            Boolean istListReferecendToProvincia = false;
            if (!istListReferecendToProvincia) {
                Optional<Provincia> provinciaOptional = provinciaSupplierServices.findByPK(document, provinciaReferenced);
                if (provinciaOptional.isPresent()) {
                    corregimiento.setProvincia(provinciaOptional.get());
                } else {
                    MessagesUtil.warning("No tiene referencia a Planeta");
                }
            } else {

                /**
                 * Pasos para @Referenced List<>
                 * 1- Obtener la lista documento 2- Obtener un List<SDocument>
                 * de las llaves primarias
                 */
                List<Provincia> provinciaList = provinciaSupplierServices.findAllByPK(document, provinciaReferenced);

                //provincia.setPais(paisList);
            }

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return corregimiento;

    }
// </editor-fold>

}
