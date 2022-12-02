package com.example.it.controller;

import com.example.JaxrsActivator;
import com.example.controller.OceanoController;
import com.example.produces.MongoDBProducer;
import com.example.repository.OceanoRepository;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ArquillianExtension.class)
public class OceanoControllerIT {

    @ArquillianResource
    URL url;
//@Inject
// OceanoService oceanoService;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
               
                .addClass(JaxrsActivator.class)
                .addClass(MongoDBProducer.class)
                .addClass(OceanoRepository.class)
                .addClass(OceanoController.class)
                .addAsResource("microprofile-config.properties", "META-INF/microprofile-config.properties")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(war.toString(true));
        return war;
    }

//    @Test
//    @RunAsClient
//    public void helloOverHttp() throws IOException, InterruptedException {
//        System.out.println("=====================================================");
//        String serviceURL = url.toString()+"/api/oceano/pacifico";
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create(serviceURL))
//                .build();
//
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        assertEquals("Oceano Pacifico", response.body());
//        System.out.println("|=====================================================|");
//    }
}
