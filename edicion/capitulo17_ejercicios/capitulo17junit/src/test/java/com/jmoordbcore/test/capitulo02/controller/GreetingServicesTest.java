/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.jmoordbcore.test.capitulo02.controller;

import com.jmoordbcore.capitulo13.mockito.GreetingService;
import com.jmoordbcore.capitulo13.produces.ConfigPropertyProvider;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author avbravo
// */
//@Log
@ExtendWith(MockitoExtension.class)
public class GreetingServicesTest {
    
    @InjectMocks
    protected GreetingService greetingService;
    
    @Mock
    protected ConfigPropertyProvider propertyProvider;
    
    @BeforeEach
    void init(){
        
    }
    
    @Test
    void testGreetingService(){
        var jsonObject = greetingService.greet("Jhonv");
//        System.out.println((\"greeting\") "+jsonObject.getString("greeting"));
        assertEquals("Hello there Jhon ", jsonObject.getString("greeting"));
        
    }
}
