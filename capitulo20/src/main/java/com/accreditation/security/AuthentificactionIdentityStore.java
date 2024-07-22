/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accreditation.security;

import com.jmoordb.core.util.ConsoleUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import jakarta.security.enterprise.identitystore.IdentityStore;
import static java.util.Arrays.asList;
import java.util.HashSet;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class AuthentificactionIdentityStore implements IdentityStore {

// <editor-fold defaultstate="collapsed" fields ">
    String userAutentification;
    String passwordAutentification;
    String secretKey = "SCox1jmWrkma$*opne2Amwz";
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Inject">

//     @Inject
//           LoggerServices loggerServices;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
    @Inject
    private Config config;
    @Inject
    @ConfigProperty(name = "userSecurity", defaultValue = "")
    private String userSecurity;
    @Inject
    @ConfigProperty(name = "passwordSecurity", defaultValue = "")
    private String passwordSecurity;

//</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="init">
    @PostConstruct
    public void init() {
        try {

        } catch (Exception e) {
        }

    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential)">
    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        try {

            /**
             * Desencripta el usuario y password que viene del archivo
             * microprofile-config y lo compara con el que viene del cliente.
             */
             
//            userAutentification = Encryptor.decrypt(userSecurity, secretKey,MessagesUtil.nameOfClassAndMethod() );
//         
//            passwordAutentification = Encryptor.decrypt(passwordSecurity, secretKey,MessagesUtil.nameOfClassAndMethod(), Boolean.TRUE );
// 
            userAutentification = userSecurity;
         
            passwordAutentification = passwordSecurity;
 
   
            if (usernamePasswordCredential.compareTo(userAutentification, passwordAutentification)) {

                return new CredentialValidationResult(userAutentification, new HashSet<>(asList("admin", "testing")));
            } else {
                 ConsoleUtil.warning("_______________________________________________________________");
                 ConsoleUtil.warning("No coinciden las credenciuales");
               ConsoleUtil.warning("[test]userAutentification: "+userAutentification + "passwordAutentification: "+passwordAutentification);
                
                 ConsoleUtil.warning("_______________________________________________________________");
            }
        } catch (Exception e) {

            System.out.println("CredentialValidationResult validate(). error: " + e.getLocalizedMessage());

        }

        return INVALID_RESULT;
    }
    // </editor-fold>
}
