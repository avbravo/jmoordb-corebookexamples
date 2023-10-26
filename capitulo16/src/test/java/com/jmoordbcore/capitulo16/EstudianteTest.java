/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo16;

import io.helidon.microprofile.testing.junit5.HelidonTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.WebTarget;
import org.eclipse.microprofile.metrics.MetricRegistry;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

/**
 *
 * @author avbravo
 */
@HelidonTest
class EstudianteTest {
    
    @Inject
    private MetricRegistry registry;

    @Inject
    private WebTarget target;

    @Test
    void findByNombre() {



        String result = target
                .path("estudiante/findbynombre")
                .queryParam("nombre", "Maria")
                .request()
                .get(String.class);
        assertThat(result, is("[{\"edad\":25,\"idestudiante\":\"7-8-5\",\"nombre\":\"Maria\"}]"));

    }
}
