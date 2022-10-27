package com.jmoordbcore;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import javax.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {
// <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
 public   Config config;
    @Inject
    @ConfigProperty(name = "mongodb.uri")
 public   String mongodburi;
// </editor-fold>
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Mongodburi= " + mongodburi));
             //.body(is("Hello from RESTEasy Reactive"));
    }

}