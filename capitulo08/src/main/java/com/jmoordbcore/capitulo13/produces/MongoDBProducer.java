/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.produces;

/**
 *
 * @author avbravo
 */
import com.jmoordb.core.annotation.DateSupport;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@DateSupport(jakartaSource = JakartaSource.JAKARTA)
public class MongoDBProducer implements Serializable {

    @Inject
    private Config config;
    @Inject
    @ConfigProperty(name = "mongodb.uri")
    private String mongodburi;
    
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
