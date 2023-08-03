/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microjakartanosql.security;


import com.avbravo.jmoordbutils.JsfUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author avbravo
 */
@Named
@ApplicationScoped
public class AutentificactionIdentityStore implements IdentityStore {

    private String roleValue = "LOGIN";


  
    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
  
        //Esta adaptado para guardar el GRUPO DEL USUARIO la validacion se hizo en LoginController
        String username = login.getCaller();
        String password = login.getPasswordAsString();

        if (!isValidUser(username, password)) {
              
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }
           
        
          if (login.getCaller().equals("avbravo@gmail.com") && login.getPasswordAsString().equals("denver16")
                  ||login.getCaller().equals("1@gmail.com") && login.getPasswordAsString().equals("1")
                  ) {
            return new CredentialValidationResult("admin", new HashSet<>(Arrays.asList("ADMIN")));
        } else if (login.getCaller().equals("user@gmail.com") && login.getPasswordAsString().equals("denver16")) {
            return new CredentialValidationResult("user", new HashSet<>(Arrays.asList("USER")));
        } else {
            return CredentialValidationResult.INVALID_RESULT;
        }
      //  return new CredentialValidationResult(username, new HashSet<>(Arrays.asList(roleValue)));

    }

    // <editor-fold defaultstate="collapsed" desc="Boolean isValidUser(String username, String password) ">
    private Boolean isValidUser(String username, String password) {
        try {
     
            if (!isValidData(username, password)) {
                return false;
            }

//          roleValue = (String)JmoordbContext.get("jmoordb_role");
         
            return true;
        } catch (Exception e) {
              JsfUtil.successMessage("isValidUser() "+e.getLocalizedMessage());
        }
        return false;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean isValidData(String username, String password)">
    private Boolean isValidData(String username, String password) {
        try {
            if (username.isEmpty() || username.equals("") || username == null) {
              //  JsfUtil.successMessage(rf.getAppMessage("warning.usernameisempty"));
                return false;
            }
            if (password.isEmpty() || password.equals("") || password == null) {
               // JsfUtil.successMessage(rf.getAppMessage("warning.passwordisempty"));
                return false;
            }
            return true;
        } catch (Exception e) {
              JsfUtil.successMessage("isValidData() "+e.getLocalizedMessage());
        }

        return false;
    }
    // </editor-fold>
}
