/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository.implementations;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Country;
import com.avbravo.mongodbatlasdriver.repository.CountryRepository;
import com.avbravo.mongodbatlasdriver.repository.CountryRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
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
public class CountryRepositoryImpl implements CountryRepository {

    @Inject
    private Config config;
     @Inject
    @ConfigProperty(name = "mongodb.database")
       private String mongodbDatabase;
   private String mongodbCollection = "country";
 
    @Inject
    MongoClient mongoClient;

    @Override
    public List<Country> findAll() {

        List<Country> list = new ArrayList<>();
        try {

            MongoDatabase database = mongoClient.getDatabase("autentification");
     
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);

            MongoCursor<Document> cursor = collection.find().iterator();
            Jsonb jsonb = JsonbBuilder.create();
            try {
                while (cursor.hasNext()) {
                    Country country = jsonb.fromJson(cursor.next().toJson(), Country.class);
                    list.add(country);
                }
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
           MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return list;
    }

    @Override
    public Optional<Country> findById(String id) {

        try {
            MongoDatabase database = mongoClient.getDatabase("autentification");
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);
            Document doc = collection.find(eq("idcountry", id)).first();
            Jsonb jsonb = JsonbBuilder.create();
            Country country = jsonb.fromJson(doc.toJson(), Country.class);
            return Optional.of(country);
        } catch (Exception e) {
           MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return Optional.empty();
    }

    @Override
    public Country save(Country country) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Country> findByCountry(String contry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
