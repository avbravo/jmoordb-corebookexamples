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
import com.jmoordbcore.capitulo13.model.Musica;
import com.jmoordbcore.capitulo13.model.*;


// </editor-fold>
@RequestScoped
public class MusicaSupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc=" public Musica get(Supplier<? extendsMusica> s, Document document) ">

    public Musica get(Supplier<? extends Musica> s, Document document) {
        Musica musica= s.get(); 
        try {
		musica.setEstilo(document.getString("estilo"));

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return musica;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (Musica musica) ">

    public Document toDocument(Musica musica) {
        System.out.println("\t\t---~[MusicaSupplier.toDocument]---");
	 Document document = new Document();
		document.put("estilo",musica.getEstilo());
	return document;

     }
    public List<Document> toDocument(List<Musica> musicaList) {
         System.out.println("\t\t---~List<>[MusicaSupplier.toDocument]---");
        List<Document> documentList_ = new ArrayList<>();
        for(Musica musica:musicaList){
            Document document = new Document();
		document.put("estilo",musica.getEstilo());
                documentList_.add(document);
        }
	 
	return documentList_;

     }
// </editor-fold>

}