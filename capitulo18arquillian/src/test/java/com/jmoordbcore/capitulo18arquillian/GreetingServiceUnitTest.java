package com.jmoordbcore.capitulo18arquillian;

import com.jmoordbcore.capitulo18arquillian.controller.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingServiceUnitTest {

    GreetingService service;

    @BeforeEach
    public void setup() {
        service = new GreetingService();
    }

    @Test
    public void testGreeting(){
       var message = service.buildGreetingMessage("JakartaEE");
        
      assertEquals(message.getMessage(), "Say Hello to JakartaEE");
    }
}
