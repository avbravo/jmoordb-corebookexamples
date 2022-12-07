/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.microjakartanosql.microprofile.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.Health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 *
 * @author avbravo
 */
@Health
@ApplicationScoped
public class BookStoreClientHealthCheck implements HealthCheck{

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.
                named("diskspace").
                up().
                withData("free", "900MB").
                build();
    }
    
}
