package com.apuntesdejava.arquillian.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 *
 * @author diego
 */
@ApplicationPath("/api")
@ApplicationScoped
public class ApplicationConfig extends Application {
    
}