/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Roll;
import edu.eci.cvds.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author User
 */
public interface RollDAO {
    
    public List<Roll> loadAll() throws PersistenceException;
    
    public void save(Roll b) throws PersistenceException;
    
}
