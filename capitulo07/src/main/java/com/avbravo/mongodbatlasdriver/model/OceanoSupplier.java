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
import com.avbravo.mongodbatlasdriver.model.Oceano;
import com.avbravo.mongodbatlasdriver.model.*;


// </editor-fold>
@RequestScoped
public class OceanoSupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc=" public Oceano get(Supplier<? extendsOceano> s, Document document) ">

    public Oceano get(Supplier<? extends Oceano> s, Document document_) {
        Oceano oceano= s.get(); 
        try {
	
	 oceano.setIdoceano(document_.getString("idoceano"));
	oceano.setOceano(document_.getString("oceano"));

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return oceano;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Oceano oceano) ">

    public Document toDocument(Oceano oceano) {
        Document document_ = new Document();
        try {
	 
		document_.put("idoceano",oceano.getIdoceano());
		document_.put("oceano",oceano.getOceano());
	

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return document_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Document> toDocument (List<Oceano> oceanoList) ">

    public List<Document> toDocument(List<Oceano> oceanoList) {
        List<Document> documentList_ = new ArrayList<>();
        try {
	 
	 for(Oceano oceano : oceanoList){
		 Document document_ = new Document();
		document_.put("idoceano",oceano.getIdoceano());
		document_.put("oceano",oceano.getOceano());
		documentList_.add(document_);
	

       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return documentList_;
     }
// </editor-fold>

}