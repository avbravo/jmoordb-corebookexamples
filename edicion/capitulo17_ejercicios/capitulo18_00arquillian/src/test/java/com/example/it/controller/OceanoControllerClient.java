package com.example.it.controller;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

/**
 *
 */
@Path("/oceano")
public interface OceanoControllerClient {

    @GET
      public String getHello(@QueryParam("idoceano") @DefaultValue("idoceano") String idoceano);

}