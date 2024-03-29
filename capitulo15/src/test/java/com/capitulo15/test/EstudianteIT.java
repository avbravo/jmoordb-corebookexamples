package com.capitulo15.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author avbravo
 */
public class EstudianteIT {

    HttpClient client;

    @BeforeEach
    public void setUp() {
        client = HttpClient.newHttpClient();

    }

    
    @Test
    void findAll() throws Exception {
        HttpRequest request = HttpRequest
                .newBuilder(new URI("http://localhost:8080/api/estudiante"))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        assertEquals("[{\"edad\":49,\"idestudiante\":\"1-2-3\",\"nombre\":\"Aristides\"},{\"edad\":25,\"idestudiante\":\"7-8-5\",\"nombre\":\"Maria\"},{\"edad\":25,\"idestudiante\":\"4-3-8\",\"nombre\":\"Luisa\"}]", response.body());
    }
   
}
