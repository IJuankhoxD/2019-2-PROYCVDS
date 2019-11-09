
package edu.eci.cvds.managedbeans;

/**
 *
 * @author David Herrera
 */
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.Session;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "inicioBean")
@SuppressWarnings("deprecation")
@SessionScoped 

public class BasePageBean implements Serializable{
     private static final Logger log = LoggerFactory.getLogger(BasePageBean.class);
     
     private String correo;
     private String password;
     private Boolean rememberMe;    
   
    
    public void doLogin() {
       
            Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
	    SecurityManager securityManager = factory.getInstance();
	    SecurityUtils.setSecurityManager(securityManager);
            Subject currentUser  = SecurityUtils.getSubject();                   
            if ( !currentUser.isAuthenticated() ){
                
                try{
                    UsernamePasswordToken token = new UsernamePasswordToken(getCorreo(), getPassword());
                    currentUser.login(token);
                    currentUser.getSession().setAttribute("correo",correo);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/menu.xhtml");
                }
               catch (UnknownAccountException ex) {
                   facesError("Unknown account");
                   log.error(ex.getMessage(), ex);
               }
               catch (IncorrectCredentialsException ex) {
                   facesError("Wrong password");
                   log.error(ex.getMessage(), ex);
               }
               catch (LockedAccountException ex) {
                   facesError("Locked account");
                   log.error(ex.getMessage(), ex);
               }
               catch (AuthenticationException | IOException | UnavailableSecurityManagerException ex) {
                   facesError("Unknown error: " + ex.getMessage());
                   log.error(ex.getMessage(), ex);
               } 
            }
            
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String pass){
        this.password = pass;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public Boolean getRememberMe(){
        return rememberMe;
    }
    public void setRememberMe(Boolean rememberMe){
        this.rememberMe = rememberMe;
    }
    
    private void facesError(String unknown_account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void logout(){
        Subject usuario = SecurityUtils.getSubject();
        usuario.logout();
    }
}
