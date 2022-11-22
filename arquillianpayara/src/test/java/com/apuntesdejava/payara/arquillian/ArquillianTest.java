package com.apuntesdejava.payara.arquillian;

import com.apuntesdejava.arquillian.domain.Sell;
import com.apuntesdejava.arquillian.exception.NoGrupoException;
import com.apuntesdejava.arquillian.exception.OutStockException;
import com.apuntesdejava.arquillian.logic.GrupoFacade;
import com.apuntesdejava.arquillian.logic.SellFacade;
import com.apuntesdejava.arquillian.model.Grupo;
import com.apuntesdejava.arquillian.repository.GrupoRepository;
import java.util.List;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Diego Silva <diego.silva@apuntesdejava.com>
 */
@RunWith(Arquillian.class)
public class ArquillianTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArquillianTest.class);

    @Inject
    private GrupoRepository grupoRepository;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "payara-arquillian.war")
                //agregando recursos en una ubicación
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                //agregando las clases que se cargarán en el entorno
                .addClasses(GrupoFacade.class, Grupo.class,
                        SellFacade.class, Sell.class);
    }

    @Test
    public void test01() {
        LOGGER.info("Test 01");
    }

    @Test
    public void testInsertGrupos() {
        LOGGER.info("-- Registrando productos");
        //insertando registros en la base de datos
        Grupo p1 = grupoRepository.create("Keyboard", 100, 20);
        Grupo p2 = grupoRepository.create("Mouse", 90, 12);
        Grupo p3 = grupoRepository.create("Monitor", 75, 30);

        //averiguando que no sean nulos
        assertNotNull(p1);
        assertNotNull(p2);
        assertNotNull(p3);

        //mostrando en pantalla lo generado
        LOGGER.info("p1:{}", p1);
        LOGGER.info("p2:{}", p2);
        LOGGER.info("p3:{}", p3);
    }

    @Test
    @UsingDataSet("datasets/products.yml")
    @ShouldMatchDataSet("datasets/after_sales.yml")
    public void testSell() {
        LOGGER.info("-- probando venta de productos");
        List<Grupo> prods = grupoRepository.findByName("silla");
        //comprobando que aparezca siquiera uno
        assertFalse("Se esperaba al menos un producto", prods.isEmpty());
        //tomando el primero
        Grupo prod = prods.get(0);
        LOGGER.info("Grupoo a vender:{}", prod);
        try {
            //se realiza la venta..
            int cantidadVender = 40;
            double mount = grupoRepository.sell(prod.getGrupoId(), cantidadVender);
            LOGGER.info("Cantidad vendida:{} \t monto de venta:{}", cantidadVender, mount);
        } catch (OutStockException ex) {
            fail("Stock insuficiente");
        } catch (NoGrupoException ex) {
            fail("No se encontró el producto solicitado");
        }
    }
    
}
