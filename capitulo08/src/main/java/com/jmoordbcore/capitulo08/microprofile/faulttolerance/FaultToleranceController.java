package com.jmoordbcore.capitulo08.microprofile.faulttolerance;

import com.jmoordbcore.capitulo08.repository.AnimalRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.Date;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;


@Path("/faulttolerance")
@ApplicationScoped
public class FaultToleranceController {

    @Inject
    AnimalRepository animalRepository;

    @Fallback(fallbackMethod = "fallback") // better use FallbackHandler
    @Timeout(500)
    @GET
    public String contadorPaises() {
        Integer count = 0;
        try {
            Date fecha = new Date();
            count = animalRepository.findAll().stream().filter(p -> (p.getFechaalimentacion().after(fecha))).map(_item -> 1).reduce(count, Integer::sum);

        } catch (Exception e) {
            //
        }
        return "Total de paises creados despues son " + String.valueOf(count);
    }

    public String fallback() {

        return "Fallback respuesta por tiempo de espera agotado.";
    }
}
