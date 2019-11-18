/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Roll;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.RollDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RollMapper;
import java.util.List;

/**
 *
 * @author User
 */
public class MyBatisRollDAO implements RollDAO{
    
        @Inject
        RollMapper rollMapper;

    @Override
    public List<Roll> loadAll() throws PersistenceException {
        try{
            return rollMapper.getRoles();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Problemas con la busqueda de los elementos",e);
        }
    }
    
    

    @Override
    public void save(Roll b) throws PersistenceException {
        try{
            rollMapper.insertRoll(b);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Problemas con el elemento a insertar",e);
        }
        
    }
    
}
