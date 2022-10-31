package com.jmoordbcore.capitulo13.supplier;
// <editor-fold defaultstate="collapsed" desc="imports">

import com.jmoordbcore.capitulo13.model.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
/**
* Java
*/
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
/**
* Jmoordb
*/
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
/**
* MongoDB
*/
import org.bson.Document;
import com.jmoordbcore.capitulo13.model.Deporte;
import com.jmoordbcore.capitulo13.model.*;


// </editor-fold>
@RequestScoped
public class DeporteSupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc=" public Deporte get(Supplier<? extendsDeporte> s, Document document) ">

    public Deporte get(Supplier<? extends Deporte> s, Document document) {
        Deporte deporte= s.get(); 
        try {
		deporte.setDeporte(document.getString("deporte"));

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return deporte;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Deporte deporte) ">

    public Document toDocument(Deporte deporte) {
        System.out.println("\t\t----[DeporteSupplier.toDocument()]-----");
	 Document document = new Document();
         
		document.put("deporte",deporte.getDeporte());
	return document;

     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Deporte deporte) ">

    public List<Document> toDocument(List<Deporte> deporteList) {
          System.out.println("\t\t----[List<> DeporteSupplier.toDocument()]-----");
        List<Document> documentList_ = new ArrayList<>();
        for(Deporte deporte:deporteList){
            Document document = new Document();
		document.put("deporte",deporte.getDeporte());
                documentList_.add(document);
        }
	 
	return documentList_;

     }
// </editor-fold>

}