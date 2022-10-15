/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository.implementations;

import com.jmoordb.core.util.MessagesUtil;
import com.avbravo.mongodbatlasdriver.model.Provincia;
import com.avbravo.mongodbatlasdriver.repository.ProvinciaRepository;
import com.avbravo.mongodbatlasdriver.supplier.ProvinciaSupplier;
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
public class ProvinciaRepositoryImpl implements ProvinciaRepository {

    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    private Config config;
     @Inject
    @ConfigProperty(name = "mongodb.database")
       private String mongodbDatabase;
      private String mongodbCollection = "provincia";
    @Inject
    MongoClient mongoClient;
// </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Supplier">
    @Inject
    ProvinciaSupplier provinciaSupplier;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Provincia> findAll()">

    @Override
    public List<Provincia> findAll() {

      List<Provincia> list = new ArrayList<>();
        try {
           
            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);
              /**
             * Ejecuta la consulta
             */
            MongoCursor<Document> cursor = collection.find().iterator();

            try {
                while (cursor.hasNext()) {

                    list.add( provinciaSupplier.get(Provincia::new, cursor.next()));
                }
            } finally {
                cursor.close();
            }
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }
        return list;
    }
// </editor-fold>
    @Override
    public Optional<Provincia> findById(String id) {

        try {
            MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
            MongoCollection<Document> collection = database.getCollection(mongodbCollection);
            Document doc = collection.find(eq("idprovincia", id)).first();
           
            Provincia provincia =provinciaSupplier.get(Provincia::new,doc);

            return Optional.of(provincia);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return Optional.empty();
    }

    @Override
    public Provincia save(Provincia provincia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Provincia> findByProvincia(String contry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
