
package edu.eci.cvds.managedbeans;

/**
 *
 * @author David Herrera
 */
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "inicioBean")
@ViewScoped

public class BasePageBean implements Serializable{
     private static final Logger log = LoggerFactory.getLogger(BasePageBean.class);
     
     private String correo;
     private String password;
     private Boolean rememberMe;
     
     
    public Subject getSubject() {
        return SecurityUtils.getSubject();
    }
    
    public void doLogin() {
        Subject currentUser  = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(getCorreo(), new Sha256Hash(getPassword()).toHex(), getRememberMe());
        try {
            currentUser.login(token);
            currentUser.getSession().setAttribute("correo",correo);
            FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
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
        catch (AuthenticationException ex) {
            facesError("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
        catch (IOException ex){
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
}
