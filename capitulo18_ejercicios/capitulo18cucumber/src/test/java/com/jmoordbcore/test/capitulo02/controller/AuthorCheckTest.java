/*
 * Copyright (C) open knowledge GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.jmoordbcore.test.capitulo02.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;



import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static jakarta.enterprise.context.BeforeDestroyed.Literal.APPLICATION;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.lang.System.Logger;
import static org.codehaus.groovy.tools.shell.util.Logger.io;
import org.junit.platform.commons.logging.LoggerFactory;

/**
 * Health check for the resource {@link GreetResource}.
 */
@Disabled
//class AuthorCheckTest extends AbstractIntegrationTest {
class AuthorCheckTest {

  

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
