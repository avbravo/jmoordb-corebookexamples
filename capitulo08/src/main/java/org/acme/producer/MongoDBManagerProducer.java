/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.producer;

/**
 *
 * @author avbravo
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MongoDBManagerProducer implements Serializable {

    @Inject
     Config config;
    @Inject
    @ConfigProperty(name = "mongodb.uri")
     String mongodburi;

    
    @Produces
    @ApplicationScoped
    public MongoClient mongoClient() {
            MongoClient mongoClient = MongoClients.create(mongodburi);
        return mongoClient;

    }

    public void close(@Disposes final MongoClient mongoClient) {
        mongoClient.close();
    }
}
