/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.avbravo.mongodbatlasdriver.model.Pais;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Aggregates.lookup;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import java.util.List;
import java.util.function.Consumer;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author avbravo
 */
public class PaisControllerTest {
    
    public PaisControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of get method, of class PaisController.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        PaisController instance = new PaisController();
        List<Pais> expResult = null;
        List<Pais> result = instance.get();
      //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }
 @Test
    public void insert() {
    try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = mongoClient.getDatabase("world");
            MongoCollection<Document> planetas = db.getCollection("planeta");
//            for(Integer i=1:)
//            planetas.insertOne(new Document("idplaneta",1).append("planeta", ));
            
//            MongoCollection<Document> books = db.getCollection("books");
//            MongoCollection<Document> authors = db.getCollection("authors");
//            books.drop();
//            authors.drop();
//            books.insertOne(new Document("_id", 1).append("title", "Super Book").append("authors", asList(1, 2)));
//            authors.insertOne(new Document("_id", 1).append("name", "Bob"));
//            authors.insertOne(new Document("_id", 2).append("name", "Alice"));
//
//            Bson pipeline = lookup("authors", "authors", "_id", "authors");
//            List<Document> booksJoined = books.aggregate(singletonList(pipeline)).into(new ArrayList<>());
//            booksJoined.forEach(printDocuments());
        }
    }

    private static Consumer<Document> printDocuments() {
        return doc -> System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));
    }

    
    
}
