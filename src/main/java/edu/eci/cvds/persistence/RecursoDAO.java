package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;

public interface RecursoDAO {
 
    public List<Recurso> loadAll() throws PersistenceException;
    
    public void save(Recurso b) throws PersistenceException;
    
    
}
