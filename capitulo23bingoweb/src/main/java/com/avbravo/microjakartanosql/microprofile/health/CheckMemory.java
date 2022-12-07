/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microjakartanosql.microprofile.health;


import com.avbravo.microjakartanosql.utils.Utils;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

/**
 *
 * @author avbravo
 */
@Liveness

@ApplicationScoped
public class CheckMemory implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        long memUsed = memBean.getHeapMemoryUsage().getUsed();
        long memMax = memBean.getHeapMemoryUsage().getMax();
        long memFree = memMax - memUsed;

        return HealthCheckResponse.named("@Liveness Memory Check")
                .withData("memory used", Utils.bytesToMegabytes(memUsed))
                .withData("memory max", Utils.bytesToMegabytes(memMax))
                .withData("memory free", Utils.bytesToMegabytes(memFree))
                .up()
                .build();

    }
}
