package com.jmoordbcore.capitulo13.supplier;
// <editor-fold defaultstate="collapsed" desc="imports">

import com.jmoordbcore.capitulo13.model.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
import com.jmoordbcore.capitulo13.model.Oceano;
import com.jmoordbcore.capitulo13.model.*;


// </editor-fold>
@RequestScoped
public class OceanoSupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc=" public Oceano get(Supplier<? extendsOceano> s, Document document) ">

    public Oceano get(Supplier<? extends Oceano> s, Document document) {
        Oceano oceano= s.get(); 
        try {
         // Quitar
          
             oceano.setIdoceano(document.getString("idoceano"));
	oceano.setOceano(document.getString("oceano"));

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return oceano;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Oceano oceano) ">

    public Document toDocument(Oceano oceano) {
         System.out.println("\t\t---~[OceanoSupplier.toDocument]---");
	 Document document = new Document();
		document.put("idoceano",oceano.getIdoceano());
		document.put("oceano",oceano.getOceano());
	return document;

     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Oceano oceano) ">

    public List<Document> toDocument(List<Oceano> oceanoList) {
         System.out.println("\t\t---~[OceanoSupplier.toDocument]---");
        List<Document> documentList_ = new ArrayList<>();
        for(Oceano oceano :oceanoList){
            Document document = new Document();
		document.put("idoceano",oceano.getIdoceano());
		document.put("oceano",oceano.getOceano());
                documentList_.add(document);
        }
	 
	return documentList_;

     }
// </editor-fold>

}