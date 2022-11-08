package com.avbravo.mongodbatlasdriver.model;
// <editor-fold defaultstate="collapsed" desc="imports">

import com.avbravo.mongodbatlasdriver.model.*;
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
import com.avbravo.mongodbatlasdriver.model.Planeta;
import com.avbravo.mongodbatlasdriver.model.*;


// </editor-fold>
@RequestScoped
public class PlanetaSupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc="inject">

    @Inject
   com.avbravo.mongodbatlasdriver.repository.OceanoRepository oceanoRepository ;
    @Inject
   OceanoSupplier oceanoSupplier ;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Planeta get(Supplier<? extendsPlaneta> s, Document document) ">

    public Planeta get(Supplier<? extends Planeta> s, Document document_) {
        Planeta planeta= s.get(); 
        try {
	
	 planeta.setIdplaneta(document_.getLong("idplaneta"));
	planeta.setPlaneta(document_.getString("planeta"));
	// Referenced List<oceano>
	 List<Document> oceanoDocumentList = (List)document_.get("oceano");
	List<Oceano> oceanoList = new ArrayList<>();
	for( Document oceanoDoc :oceanoDocumentList){
		Oceano oceano = oceanoSupplier.get(Oceano::new,oceanoDoc);
		 Optional<Oceano> oceanoOptional = oceanoRepository.findByPk(oceano.getIdoceano());
		if(oceanoOptional.isPresent()){
			oceanoList.add(oceanoOptional.get());
		}
	}
	planeta.setOceano(oceanoList);
		

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return planeta;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Planeta planeta) ">

    public Document toDocument(Planeta planeta) {
        Document document_ = new Document();
        try {
	 
		document_.put("idplaneta",planeta.getIdplaneta());
		document_.put("planeta",planeta.getPlaneta());
 
	// Referenced List<oceano>
		document_.put("oceano",oceanoSupplier.toDocument(planeta.getOceano()));
	

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return document_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Document> toDocument (List<Planeta> planetaList) ">

    public List<Document> toDocument(List<Planeta> planetaList) {
        List<Document> documentList_ = new ArrayList<>();
        try {
	 
	 for(Planeta planeta : planetaList){
		 Document document_ = new Document();
		document_.put("idplaneta",planeta.getIdplaneta());
		document_.put("planeta",planeta.getPlaneta());
 
	// Referenced List<oceano>
		document_.put("oceano",oceanoSupplier.toDocument(planeta.getOceano()));
		documentList_.add(document_);
	

       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return documentList_;
     }
// </editor-fold>

}