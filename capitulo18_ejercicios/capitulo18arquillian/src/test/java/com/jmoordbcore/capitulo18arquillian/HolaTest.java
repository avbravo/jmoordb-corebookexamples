package com.jmoordbcore.capitulo18arquillian;

import com.jmoordbcore.capitulo18arquillian.controller.GreetingMessage;
import com.jmoordbcore.capitulo18arquillian.model.Grupo;
import com.jmoordbcore.capitulo18arquillian.produces.MongoDBProducer;
import com.jmoordbcore.capitulo18arquillian.repository.GrupoRepository;
import fish.payara.arquillian.shaded.jakarta.inject.Inject;
import java.net.MalformedURLException;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//@RunWith(Arquillian.class)
@ExtendWith(ArquillianExtension.class)
public class HolaTest {

 
      
@Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "capitulo18arquillan.war")
 .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(Grupo.class,
                        GrupoRepository.class,
                        MongoDBProducer.class);
    }
    
     
     @Inject
    GrupoRepository grupoRepository;
    @BeforeEach
    public void setup() {

        System.out.println("Before.....................");
    }
    
     @AfterEach
    public void teardown() {
        System.out.println("call AfterEach");
  

    }
    
    
    @Test
    public void testGreetingMessage() {
        var message = GreetingMessage.of("Say Hello to JatartaEE");
        assertEquals(message.getMessage(), "Say Hello to JatartaEE");
    }
    
     @Test
    @DisplayName("Given a name:`JakartaEE` should return `Say Hello to JakartaEE`")
    public void findAll() throws MalformedURLException {
         

              List<Grupo> list = grupoRepository.findAll();
              System.out.println(">>>>> size "+list.size());
               assertThat(list.size()).isEqualTo(200);

    }
}
