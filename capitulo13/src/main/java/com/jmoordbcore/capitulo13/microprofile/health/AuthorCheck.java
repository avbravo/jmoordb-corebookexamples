/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmoordbcore.capitulo13.microprofile.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 *
 * @author avbravo
 */
@Readiness
@ApplicationScoped
public class AuthorCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("información")
                .up()
                .withData("Author", "Avbravo")
                .withData("Website", "https://avbravo.blogspot.com")
                .withData("Country", "Panamá")
                .build();
    }

}
