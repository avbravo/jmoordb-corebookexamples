/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo16;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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

        Response r = target
                .path("pais/findbypais")
                .queryParam("pais", "xPanamáx")
                .request()
                .get();

        int status = r.getStatus();
        
        System.out.println("Voy a testing [r.getStatus()] " + r.getStatus());
        assertThat(status, is(200));
       // assertThat(r.getStatus(), is(200));

    }
}
