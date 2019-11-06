/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet;

    
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.*;
import java.util.*;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author Grupo CVDS Proyecto 2019-2
 * 
 * 
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "inicioBean")
@SessionScoped 
public class Inicio {
    private String correo;
    private String usuario;
    private String contraseña;
    
    public Inicio(){     
    }

    public String getCorreo(){
        return correo;
    }
    public String getContraseña(){
        return contraseña;
    }
    
    public String getUsuario(){
        return usuario;
    }
   
    public void setContraseña(String pass){
        contraseña = pass;
    }
  
    public void guess(int ingresado){
    }  
    
    public void login(){
        try{
            Subject usuario = SecurityUtils.getSubject();
            Session sesion = usuario.getSession();
            sesion.setAttribute("email",correo);
            if ( !usuario.isAuthenticated() ) {
                UsernamePasswordToken token = new UsernamePasswordToken(correo, contraseña);
                token.setRememberMe(true);
                usuario.login(token);                
            }   
        }catch( IncorrectCredentialsException a){
        }         
    }
    
    
    public void logout(){
        Subject usuario = SecurityUtils.getSubject();
        usuario.logout();
    }
        
        
        
}
