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
public class Cd extends Elemento {
    
    private String descripcion;
    private String nombre;
    
    public Cd(int id, int valor, boolean disponible,String descripcion, String nombre) {
        super(id, valor, disponible);
        this.descripcion = descripcion;
        this.nombre = nombre;
        
    }
    
}