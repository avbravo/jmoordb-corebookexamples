package com.jmoordbcore.capitulo23faces.model;
// <editor-fold defaultstate="collapsed" desc="imports">

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
/**
* Java
*/
import java.time.LocalDateTime;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
/**
* Jmoordb
*/
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordb.core.util.JmoordbCoreDateUtil;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
/**
* MongoDB
*/
import org.bson.Document;
import com.jmoordbcore.capitulo23faces.model.Persona;
import com.jmoordbcore.capitulo23faces.model.*;


// </editor-fold>
@RequestScoped
public class PersonaSupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc="inject">

    @Inject
   com.jmoordbcore.capitulo23faces.repository.PaisRepository paisRepository ;
    @Inject
   PaisSupplier paisSupplier ;
    @Inject
   com.jmoordbcore.capitulo23faces.repository.AnimalRepository animalRepository ;
    @Inject
   AnimalSupplier animalSupplier ;
    @Inject
   DeporteSupplier deporteSupplier ;
    @Inject
   MusicaSupplier musicaSupplier ;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Persona get(Supplier<? extendsPersona> s, Document document) ">

    public Persona get(Supplier<? extends Persona> s, Document document_) {
        Persona persona= s.get(); 
        try {
            System.out.println("--->>>> document_.getLong(\"idpersona\") "+document_.getLong("idpersona"));
	if(persona == null ){
            System.out.println("--->>>> es null ");
            
        }
	 persona.setIdpersona(document_.getLong("idpersona"));
	persona.setNombre(document_.getString("nombre"));

	// Embedded of [deporte]
	persona.setDeporte(deporteSupplier.get(Deporte::new,(Document) document_.get("deporte")));
		

	// Embedded List<musica>
	List<Musica> musicaList = new ArrayList<>();
	List<Document> musicaDoc = (List) document_.get("musica");
	for( Document docMusica : musicaDoc){
		Musica musica = musicaSupplier.get(Musica::new, docMusica);
		musicaList.add(musica);
	};
	persona.setMusica(musicaList);
		
	// @Referenced of [pais how Referenced]
	Pais pais = paisSupplier.get(Pais::new,(Document) document_.get("pais"));
	persona.setPais(paisRepository.findByPk(pais.getIdpais()).get());
		
	// Referenced List<animal>
	 List<Document> animalDocumentList = (List)document_.get("animal");
	List<Animal> animalList = new ArrayList<>();
	for( Document animalDoc :animalDocumentList){
		Animal animal = animalSupplier.get(Animal::new,animalDoc);
		 Optional<Animal> animalOptional = animalRepository.findByPk(animal.getIdanimal());
		if(animalOptional.isPresent()){
			animalList.add(animalOptional.get());
		}
	}
	persona.setAnimal(animalList);
		

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return persona;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Persona persona) ">

    public Document toDocument(Persona persona) {
        Document document_ = new Document();
        try {
	 
		document_.put("idpersona",persona.getIdpersona());
		document_.put("nombre",persona.getNombre());

	// Embedded of deporte
		document_.put("deporte",deporteSupplier.toDocument(persona.getDeporte()));

	// Embedded List<musica>
		document_.put("musica",musicaSupplier.toDocument(persona.getMusica()));
 
	// Referenced of pais
		document_.put("pais",paisSupplier.toDocument(persona.getPais()));
 
	// Referenced List<animal>
		document_.put("animal",animalSupplier.toDocument(persona.getAnimal()));
	

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return document_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Document> toDocument (List<Persona> personaList) ">

    public List<Document> toDocument(List<Persona> personaList) {
        List<Document> documentList_ = new ArrayList<>();
        try {
	 
	 for(Persona persona : personaList){
		 Document document_ = new Document();
		document_.put("idpersona",persona.getIdpersona());
		document_.put("nombre",persona.getNombre());

	// Embedded of deporte
		document_.put("deporte",deporteSupplier.toDocument(persona.getDeporte()));

	// Embedded List<musica>
		document_.put("musica",musicaSupplier.toDocument(persona.getMusica()));
 
	// Referenced of pais
		document_.put("pais",paisSupplier.toDocument(persona.getPais()));
 
	// Referenced List<animal>
		document_.put("animal",animalSupplier.toDocument(persona.getAnimal()));
		documentList_.add(document_);
	

       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return documentList_;
     }
// </editor-fold>

}