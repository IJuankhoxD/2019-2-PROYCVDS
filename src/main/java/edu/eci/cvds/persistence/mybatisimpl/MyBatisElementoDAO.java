
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
        try{   
            return elementoMapper.getElementos();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Problemas con la busqueda de los elementos",e);
        }
    }

    @Override
    public void save(Elemento b) throws PersistenceException {
        try{
            elementoMapper.insertElemento(b);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Problemas con el elemento a insertar",e);
        }
        
    }

	
}
