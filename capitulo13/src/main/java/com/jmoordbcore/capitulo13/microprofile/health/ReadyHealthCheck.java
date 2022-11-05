package com.jmoordbcore.capitulo13.microprofile.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;


@Readiness
@ApplicationScoped
public class ReadyHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
return HealthCheckResponse.named("ready").up().build();


    }
}
