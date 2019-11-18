/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.managedbeans;

/**
 *
 * @author David Herrera
 */
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.managedbeans.BasePageBean;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.BibliotecaServicesFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@ManagedBean(name = "ElementoBean")
@ViewScoped
public class RecursoBean implements Serializable{
    
    public static final Logger log = LoggerFactory.getLogger(BasePageBean.class);
    
    private BibliotecaServices bibliotecaServices;
    
    private String nombre;
    private String tipo;
    private String ubicacion;
    private int id;
    private int capacidad;
    private boolean disponible;
    private boolean averiado;

    
    public RecursoBean(){
        bibliotecaServices = BibliotecaServicesFactory.getInstance().getBibliotecaServices();
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    public int getId(){
        return id;
    }
    public void setId(int identificador){
        this.id = identificador;
    }
    public int getCapacidad(){
        return capacidad;
    }
    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }
    
    public void registrarElemento(){
        try{
            Recurso recurso = new Recurso(id, disponible, averiado, ubicacion, nombre, capacidad,tipo);
            bibliotecaServices.insertarRecurso(recurso);
        }catch(ServicesException e){
            facesError(e.getMessage());
        }
    }
    
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage("Registrar elemento: ", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "se genero un error"));
    }
    
            
}
