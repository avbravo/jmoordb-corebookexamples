package com.avbravo.mongodbatlasdriver.producer;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.io.Serializable;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MongoDBManagerProducer implements Serializable {

    @Inject
    private Config config;
    @Inject
    @ConfigProperty(name = "mongodb.uri")
    private String mongodburi;
    @Inject
    @ConfigProperty(name = "mongodb.seconds.conecction")
    private Integer mongodbSecondsConecction;

    @Produces
    @ApplicationScoped
    public MongoClient mongoClient() {

        // MongoClient mongoClient = MongoClients.create(mongodburi);
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder().applyConnectionString(new ConnectionString(mongodburi))
                        .applyToSocketSettings(builder
                                -> builder.connectTimeout(mongodbSecondsConecction, SECONDS))
                        .build());

        System.out.println("@Produces :{Connected successfully to server.}");
        return mongoClient;

    }

    public void close(@Disposes final MongoClient mongoClient) {
        System.out.println("[@Disposes] .....");
        mongoClient.close();
    }

}
