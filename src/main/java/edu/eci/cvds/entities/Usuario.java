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
public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String password;
    private Roll rol;

    public Usuario(int id, String nombre, String correo, String password, Roll rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roll getRol() {
        return rol;
    }

    public void setRol(Roll rol) {
        this.rol = rol;
    }
    
    
    
}
