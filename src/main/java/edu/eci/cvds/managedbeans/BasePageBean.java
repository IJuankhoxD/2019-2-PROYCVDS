
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
        
        try {
            Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
	    SecurityManager securityManager = factory.getInstance();
	    SecurityUtils.setSecurityManager(securityManager);
            System.out.println(correo+"    "+password);
            Subject currentUser  = SecurityUtils.getSubject();                   
            System.out.println(correo+"    "+password);
            UsernamePasswordToken token = new UsernamePasswordToken(getCorreo(), getPassword(), getRememberMe());
            currentUser.login(token);
            currentUser.getSession().setAttribute("correo",correo);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/menu.xhtml");
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
    
    public void login() throws IOException{
        try{
            System.out.println(correo+"     "+password);
            Subject usuario = SecurityUtils.getSubject();
            
                System.out.println("ad");
            Session sesion = usuario.getSession();
            sesion.setAttribute("email",correo);
            if ( !usuario.isAuthenticated() ) {
                UsernamePasswordToken token = new UsernamePasswordToken(correo, password);
                token.setRememberMe(rememberMe);
                usuario.login(token);  
                System.out.println("ad");
                FacesContext.getCurrentInstance().getExternalContext().redirect("/menu.xhtml");
                
            }   
        }catch( IncorrectCredentialsException | UnavailableSecurityManagerException a){
        }         
    }
    
    
    public void logout(){
        Subject usuario = SecurityUtils.getSubject();
        usuario.logout();
    }
}
