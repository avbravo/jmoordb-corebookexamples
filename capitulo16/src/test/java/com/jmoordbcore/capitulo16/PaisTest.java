/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo16;

import com.jmoordbcore.capitulo16.model.Pais;
import com.jmoordbcore.capitulo16.repository.PaisRepository;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.WebTarget;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

/**
 *
 * @author avbravo
 */
@HelidonTest
public class PaisTest {

    @Inject
    private WebTarget target;
 

    @Test
    void findByPais() {
        System.out.println("**************************************************");
        String result = target
               .path("pais/findbypais")
                  .queryParam("pais", "Panamáx")
                .request()
               .get(String.class);
//        String result = target
//               .path("pais/findbypais")
//                  .queryParam("pais", "Daniela")
//                .request()
//               .get(String.class);
         assertThat(result, is("[{\"fecha\":\"2022-10-20T18:53:33.194Z[UTC]\",\"idpais\":2,\"pais\":\"Panamá\"}]"));
      

    }
}
