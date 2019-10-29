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


/**
 *
 * @author 2152069
 */

@ManagedBean(name = "guessBean")
@ApplicationScoped
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
}
