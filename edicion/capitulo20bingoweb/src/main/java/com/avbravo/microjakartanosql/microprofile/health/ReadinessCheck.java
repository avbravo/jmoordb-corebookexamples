/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.microjakartanosql.microprofile.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 *
 * @author avbravo
 */
@Readiness
public class ReadinessCheck implements HealthCheck {
 
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.builder()
                .name("readiness")
                .up()
                .build();
    }
    
}
