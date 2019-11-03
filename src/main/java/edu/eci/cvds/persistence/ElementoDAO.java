package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Elemento;

public interface ElementoDAO {
 
    public List<Elemento> loadAll() throws PersistenceException;
    
    public void save(Elemento b) throws PersistenceException;
    
    
}
