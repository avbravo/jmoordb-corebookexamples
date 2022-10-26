package com.jmoordbcore.capitulo02.microprofile.faulttolerance;

import com.jmoordbcore.capitulo02.repository.PaisRepository;
import java.util.Date;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/faulttolerance")
@ApplicationScoped
public class FaultToleranceController {

    @Inject
    PaisRepository paisRepository;

    @Fallback(fallbackMethod = "fallback") // better use FallbackHandler
    @Timeout(500)
    @GET
    public String contadorPaises() {
        Integer count = 0;
        try {
            Date fecha = new Date();
            count = paisRepository.findAll().stream().filter(p -> (p.getFecha().after(fecha))).map(_item -> 1).reduce(count, Integer::sum);//            paisList.forEach(action);
        } catch (Exception e) {
            //
        }
        return "Total de paises creados despues son " + String.valueOf(count);
    }

    public String fallback() {

        return "Fallback respuesta por tiempo de espera agotado.";
    }
}
