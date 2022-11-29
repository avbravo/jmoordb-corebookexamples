package com.nabenik.repository;

import com.nabenik.model.Pet;
import com.nabenik.produces.MongoDBProducer;
import jakarta.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ArquillianExtension.class)
public class PetRepositoryIT {

    @Inject
    PetRepository petRepository;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addClass(PetRepository.class)
                .addClass(Pet.class)
                .addPackage(MongoDBProducer.class.getPackage())
                .addAsResource(
                        "microprofile-config.properties", "META-INF/microprofile-config.properties");
//                .addAsWebInfResource("glassfish-resources.xml", "glassfish-resources.xml");


        System.out.println(war.toString(true));
        return war;
    }

    @Test
    public void fullPersistenceCycle(){
        var pet = new Pet();
        pet.setName("Dogbert");
        pet.setType("Dog");

        assertNull(pet.getId());
        petRepository.save(pet);
        assertNotNull(pet.getId());

        var rdbmsPet = petRepository.findByPk(pet.getId()).get();
        assertEquals(pet.getName(), rdbmsPet.getName());

        pet.setName("Catbert");
        pet.setType("Cat");

        petRepository.update(pet);
        rdbmsPet = petRepository.findByPk(pet.getId()).get();

        assertEquals(pet.getName(), rdbmsPet.getName());

        petRepository.deleteByPk(pet.getId());
        rdbmsPet = petRepository.findByPk(pet.getId()).get();
        assertNull(rdbmsPet);
    }
}
