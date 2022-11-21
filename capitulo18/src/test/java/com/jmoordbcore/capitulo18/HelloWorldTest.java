/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.jmoordbcore.capitulo18;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.InitializationError;

/**
 *
 * @author avbravo
 */
public class HelloWorldTest extends Arquillian {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(HelloWorld.class);
    }

    public HelloWorldTest(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Test()
    public void sayHelloTest() {
        HelloWorld helloWorld = new HelloWorld();
        Assert.assertEquals(helloWorld.sayHello(), "Hello WorldPana,");
    }
}
