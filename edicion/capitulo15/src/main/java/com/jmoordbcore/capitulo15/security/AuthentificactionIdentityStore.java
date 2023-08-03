/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmoordbcore.capitulo15.security;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
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

    String userAutentification;
    String passwordAutentification;
    // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
    @Inject
    private Config config;
    //otp
    @Inject
    @ConfigProperty(name = "userSecurity", defaultValue = "")
    private Provider<String> userSecurity;
    @Inject
    @ConfigProperty(name = "passwordSecurity", defaultValue = "")
    private Provider<String> passwordSecurity;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="init">

    @PostConstruct
    public void init() {

    }
    // </editor-fold>

    // </editor-fold> 
    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        try {
            System.out.println("----------------UsernamePasswordCredential---------------------------------");
            System.out.println("usernamePasswordCredential.getCaller() "+usernamePasswordCredential.getCaller());
            System.out.println("usernamePasswordCredential.getPasswordAsString() "+usernamePasswordCredential.getPasswordAsString());
            
            System.out.println("-------------------------------------------------");
            System.out.println("-->>> validando "+userSecurity.get() + " passwortd "+passwordSecurity.get());
//            userAutentification = Encryptor.decrypt(userSecurity.get(),"frase");
//            passwordAutentification = Encryptor.decrypt(passwordSecurity.get(),"frase");
//            
            System.out.println("-->desencriptado "+userAutentification + " : "+ passwordAutentification);

            if (usernamePasswordCredential.compareTo(userAutentification, passwordAutentification)) {
                System.out.println("----> credencial valida");
                return new CredentialValidationResult(userAutentification, new HashSet<>(asList("admin", "testing")));
            }
        } catch (Exception e) {
            System.out.println("CredentialValidationResult " + e.getLocalizedMessage());
        }

        return INVALID_RESULT;
    }

}
