package com.jmoordbcore.capitulo18arquillian;

import com.jmoordbcore.capitulo18arquillian.model.Grupo;
import com.jmoordbcore.capitulo18arquillian.produces.MongoDBProducer;
import com.jmoordbcore.capitulo18arquillian.repository.GrupoRepository;
import fish.payara.arquillian.shaded.jakarta.inject.Inject;
import java.util.List;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.runner.RunWith;


//@RunWith(Arquillian.class)
public class ArquillianTest {

    @Inject
    private GrupoRepository grupoRepository;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "capitulo18arquillan.war")
                .addClasses(GrupoRepository.class, Grupo.class,
                        MongoDBProducer.class);
    }

    @Test
    public void test01() {
        System.out.println("Test 01");
    }

    @Test
    public void testInsertProducts() {

        System.out.println(">>>> testInsertProducts..");
        List<Grupo> list = grupoRepository.findAll();
        System.out.println(">>>>>>>> Total de grupo " + list.size());
        assertEquals(1, list.size());

    }

}
