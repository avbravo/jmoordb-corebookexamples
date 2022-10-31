package com.jmoordbcore.capitulo13.supplier;
// <editor-fold defaultstate="collapsed" desc="imports">

import com.jmoordbcore.capitulo13.model.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
/**
 * Java
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
/**
 * Jmoordb
 */
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordbcore.capitulo13.repository.OceanoRepository;
import com.jmoordbcore.capitulo13.repository.PaisRepository;
/**
 * MongoDB
 */
import org.bson.Document;

// </editor-fold>
@RequestScoped
public class PersonaSupplier implements Serializable {
// <editor-fold defaultstate="collapsed" desc="inject">

    @Inject
    PaisRepository paisRepository;
    @Inject
    PaisSupplier paisSupplier;
    @Inject
    OceanoRepository oceanoRepository;
    @Inject
    OceanoSupplier oceanoSupplier;
    @Inject
    DeporteSupplier deporteSupplier;
    @Inject
    MusicaSupplier musicaSupplier;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Persona get(Supplier<? extendsPersona> s, Document document) ">

    public Persona get(Supplier<? extends Persona> s, Document document) {
        Persona persona = s.get();
        try {
            // Quitar
            System.out.println("Quitar Supplier " + document.toJson());
            persona.setIdpersona(document.getLong("idpersona"));
            persona.setNombre(document.getString("nombre"));
            // Embedded of deporte
            document.put("deporte", deporteSupplier.toDocument(persona.getDeporte()));
            // Embedded List<musica>
            List<Musica> musicaList = new ArrayList<>();
            List<Document> musicaDoc = (List) document.get("musica");
            for (Document docMusica : musicaDoc) {
                Musica musica = musicaSupplier.get(Musica::new, docMusica);
                musicaList.add(musica);
            };
            persona.setMusica(musicaList);
            document.put("musica", musicaSupplier.toDocument(persona.getMusica()));
            // Referenced of pais
            document.put("pais", paisSupplier.toDocument(persona.getPais()));
            // Referenced List<oceano>
            List<Document> oceanoDocumentList = (List) document.get("oceano");
            List<Oceano> oceanoList = new ArrayList<>();
            for (Document oceanoDoc : oceanoDocumentList) {
                Oceano oceano = oceanoSupplier.get(Oceano::new, oceanoDoc);
                Optional<Oceano> oceanoOptional = oceanoRepository.findByPk(oceano.getIdoceano());
                if (oceanoOptional.isPresent()) {
                    oceanoList.add(oceanoOptional.get());
                }
            }
            persona.setOceano(oceanoList);
            document.put("oceano", oceanoSupplier.toDocument(persona.getOceano()));

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return persona;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Persona persona) ">

    public Document toDocument(Persona persona) {
        System.out.println("-------[PersonaSupplier.toDocument()]-------");
        Document document = new Document();
        document.put("idpersona", persona.getIdpersona());
        document.put("nombre", persona.getNombre());

        // Embedded of deporte
        document.put("deporte", deporteSupplier.toDocument(persona.getDeporte()));

        // Embedded List<musica>
        List<Musica> musicaList = new ArrayList<>();
        List<Document> musicaDoc = (List) document.get("musica");
        for (Document docMusica : musicaDoc) {
            Musica musica = musicaSupplier.get(Musica::new, docMusica);
            musicaList.add(musica);
        };
        persona.setMusica(musicaList);
        document.put("musica", musicaSupplier.toDocument(persona.getMusica()));

        // Referenced of pais
        document.put("pais", paisSupplier.toDocument(persona.getPais()));

        // Referenced List<oceano>
        List<Document> oceanoDocumentList = (List) document.get("oceano");
        List<Oceano> oceanoList = new ArrayList<>();
        for (Document oceanoDoc : oceanoDocumentList) {
            Oceano oceano = oceanoSupplier.get(Oceano::new, oceanoDoc);
            Optional<Oceano> oceanoOptional = oceanoRepository.findByPk(oceano.getIdoceano());
            if (oceanoOptional.isPresent()) {
                oceanoList.add(oceanoOptional.get());
            }
        }
        persona.setOceano(oceanoList);
        document.put("oceano", oceanoSupplier.toDocument(persona.getOceano()));
        
        System.out.println("__________> PersonaSuppliet\n@document.toJson "+document.toJson());
        System.out.println("_________________________________________________________________");
        return document;

    }
// </editor-fold>

}
