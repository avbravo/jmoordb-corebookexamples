package com.jmoordbcore.capitulo13.microprofile.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class ReadyHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
return HealthCheckResponse.named("ready").up().build();


    }
}
