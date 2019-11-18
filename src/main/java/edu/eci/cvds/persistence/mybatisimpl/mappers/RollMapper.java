/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Roll;
import java.util.List;

/**
 *
 * @author User
 */
public interface RollMapper {
    public List<Roll> getRoles();
    public void insertRoll(@Param("rol") Roll elemento);
    
    
}
