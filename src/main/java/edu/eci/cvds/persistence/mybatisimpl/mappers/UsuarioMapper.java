/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;

import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author User
 */
public interface UsuarioMapper {
    
    public List<Usuario> getUsuarios();
    public void insertUsuario(@Param("usuario") Usuario usuario);
    
}
