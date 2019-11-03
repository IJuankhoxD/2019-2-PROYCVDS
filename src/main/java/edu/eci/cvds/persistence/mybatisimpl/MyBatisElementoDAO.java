
package edu.eci.cvds.persistence.mybatisimpl;


import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ElementoMapper;
import java.util.List;



public class MyBatisElementoDAO implements ElementoDAO {

	@Inject
	ElementoMapper elementoMapper;

    

    @Override
    public List<Elemento> loadAll() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Elemento b) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
}
