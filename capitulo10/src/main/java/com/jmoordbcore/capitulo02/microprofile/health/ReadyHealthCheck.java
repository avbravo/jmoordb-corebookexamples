package com.jmoordbcore.capitulo02.microprofile.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class ReadyHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
return HealthCheckResponse.named("ready").up().build();


    }
}
