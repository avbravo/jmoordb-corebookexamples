package com.jmoordbcore.capitulo18arquillian.repository;
// <editor-fold defaultstate="collapsed" desc="imports">

import com.jmoordbcore.capitulo18arquillian.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
/**
* MongoDB
*/
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonInt64;
import org.bson.conversions.Bson;
import org.bson.BsonDocument;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
/**
* Java
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Optional;
import java.util.function.Supplier;
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.util.JmoordbCoreDateUtil;
import java.util.HashSet;
import com.jmoordbcore.capitulo18arquillian.model.Grupo;


// </editor-fold>
@ApplicationScoped
public class GrupoRepositoryImpl  implements GrupoRepository{
// <editor-fold defaultstate="collapsed" desc="inject">

    @Inject
    MongoClient mongoClient;
/**
* Microprofile Config
*/
    @Inject
    Config config;
    @Inject
    @ConfigProperty(name = "mongodb.database")
    String mongodbDatabase;

    String mongodbCollection = "grupo";
/**
* AutogeneratedRepository
*/
    @Inject
    com.jmoordbcore.capitulo18arquillian.repository.AutogeneratedRepository autogeneratedRepository;
/**
* Supplier
*/
    @Inject
    com.jmoordbcore.capitulo18arquillian.model.GrupoSupplier grupoSupplier;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="java.util.stream.Stream<com.jmoordbcore.capitulo18arquillian.model.Grupo> findByGrupo(java.lang.String grupo ) ">

    @Override
    public java.util.stream.Stream<com.jmoordbcore.capitulo18arquillian.model.Grupo> findByGrupo(java.lang.String grupo) {
        List<Grupo> list = new ArrayList<>();
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               MongoCursor<Document> cursor;
               Bson filter =Filters.eq("grupo",grupo);

		cursor = collection.find( filter )
					.iterator();

               try{
                  while (cursor.hasNext()) {
                        list.add(grupoSupplier.get(Grupo::new, cursor.next()));
                  }
               } finally {
                     cursor.close();
               } 
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return list.stream();

     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Optional<Grupo> save(Grupo grupo)">

    @Override
    public Optional<Grupo> save(Grupo grupo) {
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               
               if (findByPk(grupo.getIdgrupo()).isPresent()) { 
                   MessagesUtil.warning("There is already a record with that id");
                  return Optional.of(grupo);
               }
               InsertOneResult insertOneResult = collection.insertOne(grupoSupplier.toDocument(grupo));
               if (insertOneResult.getInsertedId() != null) {
                  return Optional.of(grupo);
               }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return Optional.empty();
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Boolean update(Grupo grupo)">

    @Override
    public Boolean update(Grupo grupo) {
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               if (!findByPk(grupo.getIdgrupo()).isPresent()) { 
                   MessagesUtil.warning("Not found a record with that id");
                    return Boolean.FALSE;
               }
               Bson filter = Filters.empty();
               filter = Filters.eq("idgrupo",grupo.getIdgrupo());
               UpdateResult result = collection.updateOne(filter,grupoSupplier.toDocument(grupo));
               if (result.getModifiedCount() > 0) {
                  return Boolean.TRUE;
               }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return Boolean.FALSE;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="public List<Grupo> findAllPaginationSorted(Pagination pagination, Sorted sorted)">

    @Override
    public List<Grupo> findAllPaginationSorted(Pagination pagination, Sorted sorted) {
        List<Grupo> list = new ArrayList<>();
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               MongoCursor<Document> cursor;
               		cursor = collection.find()
					.skip(pagination.skip())
			.limit(pagination.limit())
			.sort(sorted.getSort())
		.iterator();

               try{
                  while (cursor.hasNext()) {
                        list.add(grupoSupplier.get(Grupo::new, cursor.next()));
                  }
               } finally {
                     cursor.close();
               } 
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return list;

     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="public List<Grupo> findAll()">

    @Override
    public List<Grupo> findAll() {
        List<Grupo> list = new ArrayList<>();
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               MongoCursor<Document> cursor;
               		cursor = collection.find()
				.iterator();

               try{
                  while (cursor.hasNext()) {
                        list.add(grupoSupplier.get(Grupo::new, cursor.next()));
                  }
               } finally {
                     cursor.close();
               } 
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return list;

     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="public List<Grupo> findAllPagination(Pagination pagination)">

    @Override
    public List<Grupo> findAllPagination(Pagination pagination) {
        List<Grupo> list = new ArrayList<>();
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               MongoCursor<Document> cursor;
               		cursor = collection.find()
					.skip(pagination.skip())
			.limit(pagination.limit())
		.iterator();

               try{
                  while (cursor.hasNext()) {
                        list.add(grupoSupplier.get(Grupo::new, cursor.next()));
                  }
               } finally {
                     cursor.close();
               } 
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return list;

     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="public List<Grupo> findAllSorted(Sorted sorted)">

    @Override
    public List<Grupo>  findAllSorted(Sorted sorted) {
        List<Grupo> list = new ArrayList<>();
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               MongoCursor<Document> cursor;
               		cursor = collection.find()
					.sort(sorted.getSort())
		.iterator();

               try{
                  while (cursor.hasNext()) {
                        list.add(grupoSupplier.get(Grupo::new, cursor.next()));
                  }
               } finally {
                     cursor.close();
               } 
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return list;

     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="public Optional<Grupo> findByPk(String id )">

    public Optional<Grupo> findByPk(String id ) {
        try {
            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);
            Document doc = collection.find(eq("idgrupo", id)).first();
            if(doc == null){
               return Optional.empty();
            }
            Grupo grupo = grupoSupplier.get(Grupo::new, doc);
            return Optional.of(grupo);
       } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
       }
       return Optional.empty();
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long deleteByPK(String id )">

    @Override
    public Long deleteByPk(String id){
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               MongoCursor<Document> cursor;
               Bson filter = Filters.eq("idgrupo",id);

		com.mongodb.client.result.DeleteResult deleteResult = collection.deleteOne(filter);

               return deleteResult.getDeletedCount();
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return 0L;
     }
// </editor-fold>

}