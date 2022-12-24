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
import com.jmoordbcore.capitulo23faces.model.Pais;
import com.jmoordbcore.capitulo23faces.model.*;


// </editor-fold>
@RequestScoped
public class PaisSupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc=" public Pais get(Supplier<? extendsPais> s, Document document) ">

    public Pais get(Supplier<? extends Pais> s, Document document_) {
        Pais pais= s.get(); 
        try {
	
	 pais.setIdpais(document_.getLong("idpais"));
	pais.setPais(document_.getString("pais"));
	pais.setFecha(document_.getDate("fecha"));

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return pais;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Pais pais) ">

    public Document toDocument(Pais pais) {
        Document document_ = new Document();
        try {
	 
		document_.put("idpais",pais.getIdpais());
		document_.put("pais",pais.getPais());
		document_.put("fecha",pais.getFecha());
	

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return document_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Document> toDocument (List<Pais> paisList) ">

    public List<Document> toDocument(List<Pais> paisList) {
        List<Document> documentList_ = new ArrayList<>();
        try {
	 
	 for(Pais pais : paisList){
		 Document document_ = new Document();
		document_.put("idpais",pais.getIdpais());
		document_.put("pais",pais.getPais());
		document_.put("fecha",pais.getFecha());
		documentList_.add(document_);
	

       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return documentList_;
     }
// </editor-fold>

}