/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.test.capitulo02.controller;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.testcontainers.shaded.org.apache.commons.lang.BooleanUtils.isTrue;


/**
 *
 * @author avbravo
 */
@Testcontainers
public class BasicApplicationIT {
     @Container
  GenericContainer microContainer = new GenericContainer("payara/micro-jdk11:5.2022.1")
                    .withExposedPorts(8080);

  @Test
  public void checkContainerIsRunning(){
      assert(isTrue(microContainer.isRunning()));
  }
}
