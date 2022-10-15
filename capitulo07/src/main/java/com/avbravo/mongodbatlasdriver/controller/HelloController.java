package com.avbravo.mongodbatlasdriver.controller;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author
 */
@Path("hello")
public class HelloController {

    @Inject
    MongoClient mongoClient;

    @GET
    public Response ping() {
        try {

   

        } catch (Exception e) {
            System.out.println("ping() " + e.getLocalizedMessage());
        }
        return Response
                .ok("ping")
                .build();
    }
}
