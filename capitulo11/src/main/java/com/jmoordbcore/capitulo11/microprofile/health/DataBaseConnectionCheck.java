/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmoordbcore.capitulo11.microprofile.health;

import com.jmoordbcore.capitulo11.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 *
 * @author avbravo
 */
@Readiness
@ApplicationScoped
public class DataBaseConnectionCheck implements HealthCheck {

    @Inject
    EstudianteRepository estudianteRepository;

    @Override
    public HealthCheckResponse call() {

        if (estudianteRepository.ping()) {
            return HealthCheckResponse.up("Base de datos esta en ejecución");
        } else {
            return HealthCheckResponse.down("Base de datos esta detenida");
        }

    }

   
}
