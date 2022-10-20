package com.avbravo.mongodbatlasdriver.metric;

import com.avbravo.mongodbatlasdriver.model.Pais;
import com.avbravo.mongodbatlasdriver.repository.PaisRepository;
import java.awt.print.Book;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Random;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;

@Path("/metric")
@ApplicationScoped //Required for @Gauge
public class MetricController {

    @Inject
    PaisRepository paisRepository;
    
    
    @Inject
    @Metric(name = "endpoint_counter")
    private Counter counter;

    @Timed(name = "getAllBooks",
            description = "Monitor the time getAll Method takes",
            unit = MetricUnits.MILLISECONDS,
            absolute = true)
    @GET
    public Response getAll() {
        return Response.ok(paisRepository.findAll()).build();
    }
    
    
    @Metered(name = "crear-pais",
            unit = MetricUnits.MILLISECONDS,
            description = "Monitor la rata de eventos ocurridos",
            absolute = true)
@POST
public Response create(Pais pais) {
        paisRepository.save(pais);
        return Response.ok().build();
}

    @Path("timed")
    @Timed(name = "timed-request")
    @GET
    public String timedRequest() {
        // Demo, not production style
        int wait = new Random().nextInt(1000);
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            // Demo
            e.printStackTrace();
        }

        return "Request is used in statistics, check with the Metrics call.";
    }

    @Path("increment")
    @GET
    public long doIncrement() {
        counter.inc();
        return counter.getCount();
    }

    @Gauge(name = "counter_gauge", unit = MetricUnits.NONE)
    private long getCustomerCount() {
        return counter.getCount();
    }

   

}
