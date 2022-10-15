/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository.implementations;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Persona;
import com.avbravo.mongodbatlasdriver.repository.PersonaRepository;
import com.avbravo.mongodbatlasdriver.supplier.PersonaSupplier;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.bson.Document;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
//@Stateless
public class PersonaRepositoryImpl implements PersonaRepository {

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    private Config config;
    @Inject
    @ConfigProperty(name = "mongodb.database")
    private String mongodbDatabase;
    private String mongodbCollection = "persona";
    @Inject
    MongoClient mongoClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Supplier">
    @Inject
    PersonaSupplier personaSupplier;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Persona> findAll()">

    @Override
    public List<Persona> findAll() {

        List<Persona> list = new ArrayList<>();
        try {

            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);

            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    list.add(personaSupplier.get(Persona::new, cursor.next()));
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
    public Optional<Persona> findById(String id) {

        try {
            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);
            Document doc = collection.find(eq("idpersona", id)).first();

            Persona persona = personaSupplier.get(Persona::new, doc);

            return Optional.of(persona);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return Optional.empty();
    }

    @Override
    public Persona save(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> findByPersona(String contry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
