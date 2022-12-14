package com.jmoordbcore.capitulo18arquillian.controller;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;

@ApplicationScoped
public class GreetingService {

    public GreetingMessage buildGreetingMessage(String name) {
//        return GreetingMessage.of("Say Hello to " + name + " at " + LocalDateTime.now());
        return GreetingMessage.of("Say Hello to " + name );
    }
}
