package com.jmoordbcore.capitulo16;

import org.eclipse.microprofile.metrics.MetricRegistry;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.WebTarget;

import io.helidon.microprofile.tests.junit5.HelidonTest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
                .queryParam("nombre", "Ana")
                .request()
                .get(String.class);
        assertThat(result, is("[{\"edad\":25,\"idestudiante\":\"7-8-5\",\"nombre\":\"Maria\"}]"));

    }

}
