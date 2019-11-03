/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.entities;

/**
 *
 * @author David Herrera
 */
public class Portatil extends Elemento {
    
    private String descripcion;
    
    public Portatil(int id, int valor, boolean disponible, String descripcion) {
        super(id, valor, disponible);
        this.descripcion = descripcion;
    }
    
    private String getDescripcion(){
        return descripcion;
    }
    
    private void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    
    
}
