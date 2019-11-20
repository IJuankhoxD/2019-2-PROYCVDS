/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David Herrera
 */
public class Prestamo {
    
    private Usuario usuario;
    private ArrayList<Recurso> recurso;  
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaEntrega;
    
    public Prestamo(Usuario usuario, ArrayList<Recurso> recurso, Date fechaInicio, Date fechaFin, Date fechaEntrega){
        super();
        this.usuario = usuario;
        this.recurso= recurso;
        this.fechaInicio= fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaEntrega = fechaEntrega;
    }
}
