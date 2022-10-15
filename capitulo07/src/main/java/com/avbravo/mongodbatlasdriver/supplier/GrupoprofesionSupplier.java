/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Grupoprofesion;
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
public class GrupoprofesionSupplier implements Serializable {

    // <editor-fold defaultstate="collapsed" desc="graphics">
    /**
     * Grupopresion{ }
     */
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Grupoprofesion get(Supplier<? extends Grupoprofesion> s, Document document)">
    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */
    public Grupoprofesion get(Supplier<? extends Grupoprofesion> s, Document document) {
        Grupoprofesion grupoprofesion = s.get();
        try {
            /**
             * Entidad: Grupoprofesion Grupoprofesion{ // No tiene embedded ni
             * @Referenced }
             *
             * Nivel de Trabajo : 0
             *
             * Esquema de Niveles: | Nivel 0| Grupoprofesion
             *
             */

            Jsonb jsonb = JsonbBuilder.create();
            grupoprofesion = jsonb.fromJson(document.toJson(), Grupoprofesion.class);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return grupoprofesion;

    }
// </editor-fold>

}
