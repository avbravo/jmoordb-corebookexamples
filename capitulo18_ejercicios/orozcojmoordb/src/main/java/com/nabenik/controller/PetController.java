package com.nabenik.controller;

import com.nabenik.model.Pet;
import com.nabenik.repository.PetRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/pets")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class PetController {

    @Inject
    PetRepository repository;

    @GET
    public List<Pet> findAll() {
        return repository.findAll();
    }

    @GET
    @Path("/{id}")
    public Pet findById(@PathParam("id") Long id) {
        return repository.findByPk(id).get();
    }

    @POST
    public Response create(Pet pet) {
        repository.save(pet);
        return Response.created(
                URI.create("/pets/" + pet.getId())
        ).build();

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Pet pet) {
        repository.update(pet);
        return Response.ok(pet).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Pet pet = repository.findByPk(id).get();
        repository.deleteByPk(pet.getId());
        return Response.ok().build();
    }

}
