/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.ServicesException;
import java.util.ArrayList;
import java.util.List;


public class BibliotecaServicesImpl implements BibliotecaServices {
	

	@Inject
	private RecursoDAO recursoDAO;
	
	


    @Override
    public void insertarRecurso(Recurso recurso) throws ServicesException {
        try{
            recursoDAO.save(recurso);
        }catch(PersistenceException ex) {
            throw new ServicesException("Insert error:"+ex.getLocalizedMessage(), ex);
        }
        
   
    }

    @Override
    public List<Recurso> buscarRecurso() throws ServicesException {
        try{ 
            return recursoDAO.loadAll();
        }catch(PersistenceException ex){
            throw new ServicesException("Serch error:"+ex.getLocalizedMessage(), ex);
        }
        
    }
}
