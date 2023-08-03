/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.avbravo.microjakartanosql.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import lombok.Data;

/**
 *
 * @author avbravo
 */
@Named(value = "passwordChangeController")
@ViewScoped
@Data
public class PasswordChangeController implements Serializable {
// <editor-fold defaultstate="collapsed" desc="Fields ">
  private static final long serialVersionUID = 1L;
    private String token;
    private Integer transaccionId;
    private Integer userId;
    private Boolean keyValid=Boolean.FALSE;

// </editor-fold>
    /**
     * Creates a new instance of PasswordChangeController
     */
    public PasswordChangeController() {
    }

    @PostConstruct
    public void init() {
        System.out.println("init....");
       keyValid=Boolean.FALSE;
      
    }

    // <editor-fold defaultstate="collapsed" desc="String loadParameters()>
    public String loadParameters() {
        try {
            keyValid=Boolean.FALSE;
            System.out.println("loadParameters");

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            Map params = externalContext.getRequestParameterMap();
            if(params.get("key") ==null){
                System.out.println("No se recibio el parametro key para validar el token para cambio de contraseña");
                return "";
            }
            String key = ((String) params.get("key"));
               System.out.println("lei key " +key);
            List<String> tokenizerList = processKey(key);
            if(tokenizerList == null || tokenizerList.isEmpty()){
                System.out.println("La clave enviada debe tener el siguiente formato token-transaccionId-userId");
            }else{
                System.out.println("tokenizerList.size() "+tokenizerList.size());
                if(tokenizerList.size()!=3){
                    System.out.println("No es una clave con formato valido");
                }else{
                    /**
                     * Obtiene los diversos atributos
                     */
                    token = tokenizerList.get(0);
                    transaccionId = Integer.parseInt(tokenizerList.get(1));
                    userId = Integer.parseInt(tokenizerList.get(2));
                 
         
            
         
            System.out.println("token " + token);
             System.out.println("transaccionId " + transaccionId);
            System.out.println("userId " +userId);
           
                    
                    /**
                     * Validar contra la coleccion en la base de datos
                     * que coincida token, transaccionId, userId
                     * 
                     */
                    keyValid=Boolean.TRUE;
                }
            }
            
        } catch (Exception e) {
            System.out.println("loadParameters() " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="changePassword()">

    public String onCommandButtonChangePassword() {
        try {
            System.out.println("onCommandButtonChangePassword() ");
            System.out.println("token " + token);
            System.out.println("transaccionId " + transaccionId);
        } catch (Exception e) {
            System.out.println("onCommandButtonChangePassword() " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List<String> processKey(String str) ">
    /**
     * Procesa ek key enviado donde se obtiene
     * Recibe una cadena con separadaos -
     * Por ejemplo:
     * 12345-3456-12
     * Donde el:
     *       primer elemento  (12345)--> Es un token generdado
     *       segundo elemento (3456) --> Es el numero de transaccion registrada en la base de datos para ese token
     *       tercer  parametro (12)  --> Es el userid del usuario que solicito el token
     * token
     * transaccion
     * userId
     * @param str
     * @return 
     */
     public static List<String> processKey(String str) {
    return Collections.list(new StringTokenizer(str, "-")).stream()
      .map(token -> (String) token)
      .collect(Collectors.toList());
}
// </editor-fold>
}
