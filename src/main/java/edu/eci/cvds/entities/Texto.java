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
public class Texto extends Elemento{
    
    private String categoria;
    private String nombre;
    private String descripcion;
    
    public Texto(int id, int valor, boolean disponible, String categoria, String nombre, String descripcion ) {
        super(id, valor, disponible);
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    
    
}
