
package com.avbravo.microjakartanosql.security;

import com.avbravo.jmoordbutils.JsfUtil;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
//import jakarta.security.enterprise.AuthenticationStatus;
import static jakarta.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static jakarta.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import java.io.IOException;
import java.io.Serializable;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
//import org.eclipse.microprofile.config.Config;
//import org.eclipse.microprofile.config.inject.ConfigProperty;


/**
 *
 * @author avbravo
 */
@Named
@SessionScoped
@Data
public class LoginController implements Serializable {
    // <editor-fold defaultstate="collapsed" desc="field">
    @NotNull
    private String username;

    @NotNull
    private String password;
private String profile;  

@NotNull
    private Boolean remember =Boolean.FALSE;
    // </editor-fold>
        
// <editor-fold defaultstate="collapsed" desc="inject()">
 

    @Inject
    private SecurityContext securityContext;

    @Inject
    private FacesContext facesContext;
    
       @Inject
    private ExternalContext externalContext;
    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Microprofile Config">
//   @Inject
//   ConfigProducer configProducer;
   
 // </editor-fold>
        
    /**
     * Creates a new instance of AccessSecurity
     */
    public LoginController() {
        System.out.println("---->constructor ");
    }
      // <editor-fold defaultstate="collapsed" desc="init">
    @PostConstruct
    public void init() {
        try {
            System.out.println("---> init...");
            // Usuario logeado
          
        } catch (Exception e) {
            
            System.out.println(JsfUtil.nameOfClass()  + " "+JsfUtil.nameOfMethod());
        }
    }

    // </editor-fold>
    
    
        public void autoLogin() throws IOException {
        String emailCookie = Faces.getRequestCookie("admin-email");
        String passCookie = Faces.getRequestCookie("admin-pass");
        if (has(emailCookie) && has(passCookie)) {
            this.username = emailCookie;
            this.password = passCookie;
            login();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="login()">
     public void login() {
         try {
             
        
         
         Credential credential =
            new UsernamePasswordCredential(username, new Password(password));

        switch(continueAuthentication()){
            case SEND_CONTINUE:
                  facesContext.responseComplete();
                  break;
            case SEND_FAILURE:
                 addError(facesContext, "Authentication failed");
                 break;
              case SUCCESS:
                   externalContext.getFlash().setKeepMessages(true);
                JsfUtil.successMessage("Logged in successfully as <b>" + username + "</b>");
                if (remember) {
                    storeCookieCredentials(username, password);
                }
                Faces.redirect("faces/index.xhtml");
//                Faces.redirect("faces/index.xhtml?faces-redirect=true");
//                Faces.redirect("/faces/index.xhtml?faces-redirect=true");
                 //return "/faces/index.xhtml?faces-redirect=true";
                break;
            case NOT_DONE:
                Messages.addError(null, "Login failed");
        }

 } catch (Exception e) {
  Messages.addError(null, e.getLocalizedMessage());
         }
       
    }
    // </editor-fold>
    
     // Invalidate the session and send a redirect.
public void logout() {
    try {
          if(has(Faces.getRequestCookie("admin-email"))) {
            Faces.removeResponseCookie("admin-email",null);
            Faces.removeResponseCookie("admin-pass",null);
         
    
        }
               Faces.invalidateSession();
          Faces.redirect("faces/login.xhtml"); // Can by the way also be done by return "login?faces-redirect=true" if in action method.
    } catch (Exception e) {
       Messages.addError(null, JsfUtil.nameOfMethod() + " " +e.getLocalizedMessage());
    }
  
}
     
//        // <editor-fold defaultstate="collapsed" desc="String logout()">
//    public String logout() {
////        return logout(applicativePath+ "/faces/login.xhtml?faces-redirect=true");
//return "";
//    }
//    // </editor-fold>
    
//    
//     // <editor-fold defaultstate="collapsed" desc="String logout(String path)">
//    public String logout(String path) {
//        Boolean loggedIn = false;
//        try {
//
//            //Guarda el registro del acceso
//            String ip = JsfUtil.getIp() == null ? "" : JsfUtil.getIp();
////            Access access = new Access.Builder()
////                    .idaccess(0)
////                    .date(DateUtil.getFechaHoraActual())
////                    .ip(ip)
////                    .username(user.getUsername())
////                    .idapplicative(applicativeId.get())
////                    .event("logout")
////                    .iddepartament(profile.getIddepartament())
////                    .idprofile(profile.getIdprofile())
////                    .idrole(profile.getIdrole())
////                    .build();
////
////            accessEvent.fire(new AccessEvent(access));
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            if (session != null) {
//                session.invalidate();
//            }
//            String url = (path);
//            FacesContext fc = FacesContext.getCurrentInstance();
//            ExternalContext ec = fc.getExternalContext();
//            ec.redirect(url);
//            return path;
//        } catch (Exception e) {
//        // loggerServices.processException(JsfUtil.nameOfClass(), JsfUtil.nameOfMethod(), e, true);
//        }
//        return path;
//    }
//// </editor-fold>

    private void addError(FacesContext facesContext, String authentication_failed) {
     Messages.addError(null, authentication_failed);
    }

    // <editor-fold defaultstate="collapsed" desc="storeCookieCredentials()">
     private void storeCookieCredentials(final String email, final String password) {
       Faces.addResponseCookie("admin-email", email, 1800);//store for 30min
       Faces.addResponseCookie("admin-pass", password, 1800);//store for 30min
    }
    // </editor-fold>
     
       public static boolean has(String text) {
        if (text != null && text.trim().length() > 0) {
            return true;
        }
        return false;
    }
    
       
    // <editor-fold defaultstate="collapsed" desc="AuthenticationStatus continueAuthentication()()">
    private AuthenticationStatus continueAuthentication() {
        return securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters.withParams()
                        .credential(new UsernamePasswordCredential(username, password))
        );
    }
    
    public boolean isLoggedIn() {
        return securityContext.getCallerPrincipal() != null;
    }
    public String getCurrentUser() {
        return securityContext.getCallerPrincipal() != null ? securityContext.getCallerPrincipal().getName() : "";
    }
    
}
