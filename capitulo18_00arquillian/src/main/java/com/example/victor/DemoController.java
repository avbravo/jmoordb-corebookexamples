package com.example.victor;



import com.example.repository.OceanoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

@Path("/demo")

public class DemoController {


    
    HelloService helloService;

    @Inject
    public DemoController(HelloService helloService) {
        this.helloService = helloService;
        
    }

    @GET
    public String getHello(@QueryParam("name") @DefaultValue("victor") String name) {
        return helloService.createHello(name);
    }

}
