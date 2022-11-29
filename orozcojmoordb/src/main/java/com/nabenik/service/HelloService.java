package com.nabenik.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String createHello(String name) {
        return "Hello " + name;
    }

}
