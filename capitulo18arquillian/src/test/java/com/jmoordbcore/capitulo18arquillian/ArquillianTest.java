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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(Arquillian.class)
public class ArquillianTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArquillianTest.class);

    @Inject
    private GrupoRepository grupoRepository;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "capitulo18arquillan.war")
                //agregando recursos en una ubicación
//                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                //agregando las clases que se cargarán en el entorno
                .addClasses(GrupoRepository.class, Grupo.class,
                        MongoDBProducer.class);
    }

    @Test
    public void test01() {
        LOGGER.info("Test 01");
    }

    @Test
    public void testInsertProducts() {
        LOGGER.info("-- Registrando productos");
        //insertando registros en la base de datos
//        Product p1 = productFacade.create("Keyboard", 100, 20);
//        Product p2 = productFacade.create("Mouse", 90, 12);
//        Product p3 = productFacade.create("Monitor", 75, 30);
System.out.println(">>>> testInsertProducts..");
List<Grupo> list = grupoRepository.findAll();
        System.out.println(">>>>>>>> Total de grupo "+list.size());
assertEquals(1, list.size());
        //averiguando que no sean nulos
//        assertNotNull(p1);
//        assertNotNull(p2);
//        assertNotNull(p3);

        //mostrando en pantalla lo generado
//        LOGGER.info("p1:{}", p1);
//        LOGGER.info("p2:{}", p2);
//        LOGGER.info("p3:{}", p3);
    }

//    @Test
//    @UsingDataSet("datasets/products.yml")
//    @ShouldMatchDataSet("datasets/after_sales.yml")
//    public void testSell() {
//        LOGGER.info("-- probando venta de productos");
//        List<Product> prods = productFacade.findByName("silla");
//        //comprobando que aparezca siquiera uno
//        assertFalse("Se esperaba al menos un producto", prods.isEmpty());
//        //tomando el primero
//        Product prod = prods.get(0);
//        LOGGER.info("Producto a vender:{}", prod);
//        try {
//            //se realiza la venta..
//            int cantidadVender = 40;
//            double mount = productFacade.sell(prod.getProductId(), cantidadVender);
//            LOGGER.info("Cantidad vendida:{} \t monto de venta:{}", cantidadVender, mount);
//        } catch (OutStockException ex) {
//            fail("Stock insuficiente");
//        } catch (NoProductException ex) {
//            fail("No se encontró el producto solicitado");
//        }
//    }
    
}
