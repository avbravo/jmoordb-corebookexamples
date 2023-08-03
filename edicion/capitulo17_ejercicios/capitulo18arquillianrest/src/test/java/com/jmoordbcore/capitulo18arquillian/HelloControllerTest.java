package com.jmoordbcore.capitulo18arquillian;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.jmoordbcore.capitulo18arquillian.controller.GreetingMessage;
import com.jmoordbcore.capitulo18arquillian.controller.HelloController;
import com.jmoordbcore.capitulo18arquillian.model.Grupo;
import com.jmoordbcore.capitulo18arquillian.produces.MongoDBProducer;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;
import static org.assertj.core.api.Assertions.assertThat;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

/**
 *
 * @author avbravo
 */
@ExtendWith(ArquillianExtension.class)
//@RunWith(Arquillian.class)
public class HelloControllerTest {
    
//
//    
//      @Deployment
//    public static WebArchive createDeployment() {
//        return ShrinkWrap.create(WebArchive.class, "capitulo18arquillan.war")
//                //agregando recursos en una ubicación
////                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
//                //agregando las clases que se cargarán en el entorno
//                .addClasses(HelloController.class, Grupo.class,
//                        MongoDBProducer.class);
//    }
//  @ArquillianResource
//    private URL base;
//    
//    private Client client;
//    
//    @BeforeEach
//    public void setup() {
//
//        this.client = ClientBuilder.newClient();
//        //removed the Jackson json provider registry, due to OpenLiberty 21.0.0.1 switched to use Resteasy.
//    }
//    
//    
//      @AfterEach
//    public void teardown() {
//        System.out.println("call AfterEach");
//  
//        if (this.client != null) {
//            this.client.close();
//        }
//    }
//    
//    @Test
//    @DisplayName("Given a name:`JakartaEE` should return `Say Hello to JakartaEE`")
//    public void should_create_greeting() throws MalformedURLException {
//        
//        System.out.println(" client: {0}, baseURL: {1}" + new Object[]{client, base});
//        final var greetingTarget = this.client.target(new URL(this.base, "api/hello").toExternalForm());
//        try (final Response greetingGetResponse = greetingTarget.request()
//                .accept(MediaType.APPLICATION_JSON)
//                .get()) {
//            assertThat(greetingGetResponse.getStatus()).isEqualTo(200);
//            assertThat(greetingGetResponse.readEntity(GreetingMessage.class).getMessage()).startsWith("Say Hello to JakartaEE");
//        }
//    }
}
