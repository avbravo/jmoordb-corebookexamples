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
import com.jmoordbcore.capitulo13.model.Pais;
import com.jmoordbcore.capitulo13.model.*;


// </editor-fold>
@RequestScoped
public class PaisSupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc=" public Pais get(Supplier<? extendsPais> s, Document document) ">

    public Pais get(Supplier<? extends Pais> s, Document document) {
        Pais pais= s.get(); 
        try {
         // Quitar
             System.out.println("Quitar Supplier "+document.toJson());		 pais.setIdpais(document.getLong("idpais"));
	pais.setPais(document.getString("pais"));
	pais.setFecha(document.getDate("fecha"));

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return pais;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Pais pais) ">

    public Document toDocument(Pais pais) {
         System.out.println("\t\t---~[PaisSupplier.toDocument]---");
	 Document document = new Document();
		document.put("idpais",pais.getIdpais());
		document.put("pais",pais.getPais());
		document.put("fecha",pais.getFecha());
	return document;

     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Pais pais) ">

    public List<Document> toDocument(List<Pais> paisList) {
         System.out.println("\t\t---~List[PaisSupplier.toDocument]---");
        List<Document> documentList_ = new ArrayList<>();
        for(Pais pais:paisList){
 	 Document document = new Document();
		document.put("idpais",pais.getIdpais());
		document.put("pais",pais.getPais());
		document.put("fecha",pais.getFecha());
                documentList_.add(document);
           
        }
	return documentList_;

     }
// </editor-fold>

}