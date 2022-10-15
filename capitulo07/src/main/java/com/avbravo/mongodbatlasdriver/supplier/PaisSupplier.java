/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Idioma;
import com.avbravo.mongodbatlasdriver.model.Musica;
import com.avbravo.mongodbatlasdriver.model.Oceano;
import com.avbravo.mongodbatlasdriver.model.Pais;
import com.avbravo.mongodbatlasdriver.model.Planeta;
import com.avbravo.mongodbatlasdriver.repository.PlanetaRepository;
import com.avbravo.mongodbatlasdriver.supplier.services.OceanoSupplierServices;
import com.avbravo.mongodbatlasdriver.supplier.services.PlanetaSupplierServices;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@RequestScoped
public class PaisSupplier implements Serializable {

    // <editor-fold defaultstate="collapsed" desc="graphics">
    /**
     * Pais{
     *
     * @Referenced Planeta
     * @Referenced Oceano
     * @Embedded Idioma idioma;
     * @Embedded List<Musica>; }
     *
     */
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    PlanetaSupplierServices planetaSupplierServices;
    @Inject
    PlanetaRepository planetaRepository;
    @Inject
    OceanoSupplierServices oceanoSupplierServices;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Pais get(Supplier<? extends Pais> s, Document document)">
    public Pais get(Supplier<? extends Pais> s, Document document) {
        Pais pais = s.get();
        try {

            /**
             * --------------------------------------------------------
             *
             * Step:0
             * <Attributes and @Embedded>
             * --------------------------------------------------------
             */
            pais.setIdpais(String.valueOf(document.get("idpais")));
            pais.setPais(String.valueOf(document.get("pais")));

            /**
             * ---------------------------------------------
             *
             * @Embedded simple ----------------------------------------------
             */
            Document doc = (Document) document.get("idioma");
            Jsonb jsonb = JsonbBuilder.create();
            Idioma idioma = jsonb.fromJson(doc.toJson(), Idioma.class);
            pais.setIdioma(idioma);

            /**
             * --------------------------------------------------
             *
             * @Embedded List<Musica>
             * Debe utilizar una lista temporal para almacenar los valores
             * --------------------------------------------------
             */
            List<Musica> musicaList = new ArrayList<>();
            List<Document> musicDoc = (List) document.get("musica");
            for (Document docm : musicDoc) {
                Musica musica = jsonb.fromJson(docm.toJson(), Musica.class);
                musicaList.add(musica);
            }
            pais.setMusica(musicaList);

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
            /* --------------------------------------------------
             * @Referenced Planeta planeta;
             * Es una referencia simple no usa List
             * Leer la anotacion  @Referenced
             * @Referenced(from = "planeta",localField = "planeta.idplaneta",foreignField = "idplaneta",as ="planeta")
             *  private Planeta planeta;
             * --------------------------------------------------
             */
            Referenced planetaReferenced = new Referenced() {
                @Override
                public String from() {
                    return "planeta";
                }

                @Override
                public String localField() {
                    return "planeta.idplaneta";
                }

                @Override
                public String foreignField() {
                    return "idplaneta";
                }

                @Override
                public String as() {
                    return "planeta";
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
            Boolean istListReferecendToPlaneta = false;
            if (!istListReferecendToPlaneta) {
                Optional<Planeta> planetaOptional = planetaSupplierServices.findByPK(document, planetaReferenced);
                if (planetaOptional.isPresent()) {
                    pais.setPlaneta(planetaOptional.get());
                } else {
                    MessagesUtil.warning("No tiene referencia a Planeta");
                }
            } else {

                /**
                 * Pasos para @Referenced List<>
                 * 1- Obtener la lista documento 2- Obtener un List<SDocument>
                 * de las llaves primarias
                 */
                List<Planeta> planetaList = new ArrayList<>();
                
                List<Integer> planetaPKList = (List)document.get("planeta.idplaneta");
                for(Integer index :planetaPKList){
                    Optional<Planeta> planetaOptional=planetaRepository.findByPK(index);
                    if(planetaOptional.isPresent()){
                        planetaList.add(planetaOptional.get());
                    }
                    
                }
                pais.setPlaneta(planetaList);
                
   //             List<Planeta> planetaList = planetaSupplierServices.findAllByPK(document, planetaReferenced);

                //pais.setPlaneta(planetaList);
            }
            /* --------------------------------------------------
             * @Referenced List<Oceano> oceano;
             * Es una List<> referenciada
             * --------------------------------------------------
             */
            Referenced oceanoReferenced = new Referenced() {
                @Override
                public String from() {
                    return "oceano";
                }

                @Override
                public String localField() {
                    return "oceano.idoceano";
                }

                @Override
                public String foreignField() {
                    return "idoceano";
                }

                @Override
                public String as() {
                    return "oceano";
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

            Boolean istListReferecendToOceano = true;
            if (!istListReferecendToOceano) {
                Optional<Oceano> oceanoOptional = oceanoSupplierServices.findByPK(document, oceanoReferenced);

                if (oceanoOptional.isPresent()) {
                    //   pais.setOceano(oceanoOptional.get());
                } else {
                    MessagesUtil.warning("No tiene referencia a " + oceanoReferenced.from());
                }
            } else {

                /**
                 * Pasos para @Referenced List<>
                 * 1- Obtener la lista documento 2- Obtener un List<SDocument>
                 * de las llaves primarias
                 */
                List<Oceano> oceanoList = oceanoSupplierServices.findAllByPK(document, oceanoReferenced);;

                /**
                 * Si fuera referenciado se elimina el comentario
                 */
                pais.setOceano(oceanoList);
            }

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return pais;

    }
// </editor-fold>

}
