/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.mongodbatlasdriver.health;

import java.io.File;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 *
 * @author avbravo
 */
@Readiness
@ApplicationScoped
public class CheckDiskspace implements HealthCheck {

    private static final String readinessCheck = "@Readiness Disk Check";
    File file = new File("/");
    long freeSpace = file.getFreeSpace() / 1024 / 1024;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("@Readiness disk")
                .withData("freeSpace", freeSpace)
                .up()
                .build();

    }
}
