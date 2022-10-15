/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository.implementations;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Profesion;
import com.avbravo.mongodbatlasdriver.repository.AutogeneratedRepository;
import com.avbravo.mongodbatlasdriver.repository.ProfesionRepository;
import com.avbravo.mongodbatlasdriver.supplier.ProfesionSupplier;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.bson.Document;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
//@Stateless
public class ProfesionRepositoryImpl implements ProfesionRepository {

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    private Config config;
    @Inject
    @ConfigProperty(name = "mongodb.database")
    private String mongodbDatabase;
    private String mongodbCollection = "profesion";
    @Inject
    MongoClient mongoClient;
    @Inject
    ProfesionSupplier profesionSupplier;

    @Inject
    AutogeneratedRepository autogeneratedRepository;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Supplier">
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Profesion> findAll()">

    @Override
    public List<Profesion> findAll() {

        List<Profesion> list = new ArrayList<>();
        try {

            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);

            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    list.add(profesionSupplier.get(Profesion::new, cursor.next()));
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

    @Override
    public Optional<Profesion> findById(String id) {

        try {
            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);
            Document doc = collection.find(eq("idprofesion", id)).first();

            Profesion profesion = profesionSupplier.get(Profesion::new, doc);

            return Optional.of(profesion);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return Optional.empty();
    }
 // <editor-fold defaultstate="collapsed" desc="Optional<Profesion> save(Profesion oceano)">

    @Override
    public Optional<Profesion> save(Profesion profesion) { 
        try { 
            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);

            
            profesion.setIdprofesion(autogeneratedRepository.generate(mongodbDatabase, mongodbCollection));
            Jsonb jsonb = JsonbBuilder.create();

            InsertOneResult insertOneResult = collection.insertOne(Document.parse(jsonb.toJson(profesion)));
            if (insertOneResult.getInsertedId() != null) {
                return Optional.of(profesion);
            }

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return Optional.empty();

    }
    // </editor-fold>
 // <editor-fold defaultstate="collapsed" desc="Optional<Profesion> save(Profesion oceano)">

    @Override
    public Boolean saveProfesion(Profesion profesion) { 
        try { 
            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);

            
            profesion.setIdprofesion(autogeneratedRepository.generate(mongodbDatabase, mongodbCollection));
            Jsonb jsonb = JsonbBuilder.create();

            InsertOneResult insertOneResult = collection.insertOne(Document.parse(jsonb.toJson(profesion)));
            if (insertOneResult.getInsertedId() != null) {
                return Boolean.TRUE;
            }

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return Boolean.FALSE;

    }
    // </editor-fold>


    @Override
    public Boolean deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Profesion> findByProfesion(String contry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Profesion> findBPKOfEntity((Integer idprofesion ) {">

   private Optional<Profesion> findBPKOfEntity(Integer idprofesion ) {
       try {
             MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
             MongoCollection<Document> collection = database.getCollection(mongodbCollection);
             Document doc = collection.find(eq("idprofesion", idprofesion)).first();
             Profesion profesion = profesionSupplier.get(Profesion::new, doc); 
             return Optional.of(profesion);
       } catch (Exception e) {
         MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
       }
      return Optional.empty();
   }
// </editor-fold>

}
