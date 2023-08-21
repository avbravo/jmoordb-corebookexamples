/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.eclipse.jakarta.hello.restclient;

import fish.payara.arquillian.inject.Inject;
import org.eclipse.jakarta.hello.model.Estudiante;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
/**
 *
 * @author avbravo
 */
@RunWith(Arquillian.class)
public class EstudianteRestClientTest {
    
    @Deployment()
    public static WebArchive createDeployment() {
        final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addClass(EstudianteRestClient.class)
                .addClass(Estudiante.class)
               .addAsWebInfResource(new StringAsset("<beans/>"), "beans.xml")
                .addAsResource("META-INF/microprofile-config.properties");
        return webArchive;
    }
    
    @Inject
    @RestClient
    private EstudianteRestClient bookResourceClient;

    @Test()
    public void testServerStatus(){
        bookResourceClient.save(new Estudiante("x","TomEE Book",45));
    }
    
    

    /**
     * Test of findAll method, of class EstudianteRestClient.
     */
    @Test
    public void testFindAll() {
        
        assertTrue(bookResourceClient.findAll().size() == 3);
//        System.out.println("findAll");
//        EstudianteRestClient instance = new EstudianteRestClientImpl();
//        List<Estudiante> expResult = null;
//        List<Estudiante> result = bookResourceClient.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findByIdestudiante method, of class EstudianteRestClient.
     */
//    @Test
//    public void testFindByIdestudiante() {
//        System.out.println("findByIdestudiante");
//        String idestudiante = "";
//        EstudianteRestClient instance = new EstudianteRestClientImpl();
//        Estudiante expResult = null;
//        Estudiante result = instance.findByIdestudiante(idestudiante);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of save method, of class EstudianteRestClient.
//     */
//    @Test
//    public void testSave() {
//        System.out.println("save");
//        Estudiante estudiante = null;
//        EstudianteRestClient instance = new EstudianteRestClientImpl();
//        Response expResult = null;
//        Response result = instance.save(estudiante);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class EstudianteRestClient.
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Estudiante estudiante = null;
//        EstudianteRestClient instance = new EstudianteRestClientImpl();
//        Response expResult = null;
//        Response result = instance.update(estudiante);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class EstudianteRestClient.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        String idestudiante = "";
//        EstudianteRestClient instance = new EstudianteRestClientImpl();
//        Response expResult = null;
//        Response result = instance.delete(idestudiante);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findByNombre method, of class EstudianteRestClient.
//     */
//    @Test
//    public void testFindByNombre() {
//        System.out.println("findByNombre");
//        String nombre = "";
//        EstudianteRestClient instance = new EstudianteRestClientImpl();
//        List<Estudiante> expResult = null;
//        List<Estudiante> result = instance.findByNombre(nombre);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    public class EstudianteRestClientImpl implements EstudianteRestClient {
//
//        public List<Estudiante> findAll() {
//            return null;
//        }
//
//        public Estudiante findByIdestudiante(String idestudiante) {
//            return null;
//        }
//
//        public Response save(Estudiante estudiante) {
//            return null;
//        }
//
//        public Response update(Estudiante estudiante) {
//            return null;
//        }
//
//        public Response delete(String idestudiante) {
//            return null;
//        }
//
//        public List<Estudiante> findByNombre(String nombre) {
//            return null;
//        }
    }
    

