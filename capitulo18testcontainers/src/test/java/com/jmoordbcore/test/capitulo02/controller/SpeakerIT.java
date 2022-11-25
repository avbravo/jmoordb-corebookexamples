/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.test.capitulo02.controller;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.nio.file.Paths;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

/**
 *
 * @author avbravo
 */
@Testcontainers
public class SpeakerIT {

    MountableFile warFile = MountableFile.forHostPath(Paths.get("target/capitulo18testcontainers.war").toAbsolutePath(), 0777);

    @Container
    GenericContainer microContainer = new GenericContainer("payara/micro:6.2022.1")
            .withExposedPorts(8080)
            .withCopyFileToContainer(warFile, "/opt/payara/deployments/app.war")
            .waitingFor(Wait.forLogMessage(".* Payara Micro .* ready in .*\\s", 1))
            .withCommand("--deploy /opt/payara/deployments/app.war --contextRoot /");



  @Test
  void checkHealth() {


    RequestSpecification requestSpecification = new RequestSpecBuilder()
        .build();

    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .when()
        .get("/health")
        .then()
        .contentType(MediaType.APPLICATION_JSON)
        .statusCode(Response.Status.OK.getStatusCode())
        .body("status", Matchers.equalTo("UP"))
        .rootPath("checks.find{ it.name == 'GreetResource' }")
        .body("status", Matchers.equalTo("UP"));
  }

}