/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.test.capitulo02.controller;

import com.jmoordbcore.capitulo13.JakartaRestConfiguration;
import com.jmoordbcore.capitulo13.mockito.HelloResource;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.Objects;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.asset.UrlAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author avbravo
 */
@ExtendWith(ArquillianExtension.class)
public class HelloResourcesIT {
    @Inject
    HelloResource helloResource;
    
    
    @ArquillianResource
    protected URL contexPath;
    
    protected static HttpClient httpClient;
    
    static Jsonb jsonb;
    
    @BeforeAll
    public static void initAll(){
        httpClient = HttpClient.newBuilder().build();
    //    jsonb = JsonBuilder.create();
        
    }
    
    @Deployment
    public static WebArchive createLogicalDeployment() throws URISyntaxException{
        final JavaArchive javaArchive = ShrinkWrap.create(
        JavaArchive.class,"capitulo18junit.jar")
                .addPackage(JakartaRestConfiguration.class.getPackage())
                .addAsManifestResource(new FileAsset(new File("src/test/resources/META-INF/beans.xml")),"beans.xml")
                .addAsResource(new UrlAsset(Objects.requireNonNull(HelloResourcesIT.class.getResource("/microprofile-cofig.properties")))
                        ,"META/INF/microprofile-config.properties")
        ;
//        JavaArchive.getContent().forEach((key,value) ->System.out.println("-->"+value        ));
                return ShrinkWrap.create(WebArchive.class,"capitulo18junit.war").addAsLibrary(javaArchive);
                
                
    }
    
    

    @Test
    @RunAsClient
    public void helloOverHttp() {
           var jsonObject = helloResource.hello("Jhon Jakes");
           assertNotNull(jsonObject);
//        System.out.println((\"greeting\") "+jsonObject.getString("greeting"));
        assertEquals("Hello there Jhon Jakes ", jsonObject.getString("greeting"));
        
          
    }
    
}
