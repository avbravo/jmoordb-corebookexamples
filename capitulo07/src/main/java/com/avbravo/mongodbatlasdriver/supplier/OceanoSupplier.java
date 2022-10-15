/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Oceano;
import java.io.Serializable;
import java.util.function.Supplier;
import javax.enterprise.context.RequestScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@RequestScoped
public class OceanoSupplier implements Serializable {

    // <editor-fold defaultstate="collapsed" desc="graphics">
    /**
     * Ocenao{ }
     */
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Oceano get(Supplier<? extends Oceano> s, Document document)">
    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */
    public Oceano get(Supplier<? extends Oceano> s, Document document) {

        Oceano oceano = s.get();
        try {

            /**
             * Entidad: Oceano Oceano{ // No tiene embedded ni @Referenced }
             *
             * Nivel de Trabajo : 0
             *
             * Esquema de Niveles: | Nivel 0| Oceano
             *
             */
            Jsonb jsonb = JsonbBuilder.create();
            oceano = jsonb.fromJson(document.toJson(), Oceano.class);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());

        }
        return oceano;

    }
// </editor-fold>

}
