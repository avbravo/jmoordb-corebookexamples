/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.producer;

/**
 *
 * @author avbravo
 */
import com.jmoordb.core.annotation.DateSupport;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@DateSupport(jakartaSource = JakartaSource.JAVAEE_LEGACY)
public class MongoDBProducer implements Serializable {
    
}
