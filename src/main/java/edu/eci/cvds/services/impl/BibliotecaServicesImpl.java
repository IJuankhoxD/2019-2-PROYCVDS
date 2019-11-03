/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;


import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.PersistenceException;

import edu.eci.cvds.services.BibliotecaServices;
import edu.eci.cvds.services.ServicesException;


/**
 *
 * @author fchaves
 * @author salzate
 */
public class BibliotecaServicesImpl implements BibliotecaServices {

	

	@Inject
	private ElementoDAO elementoDAO;
	
	


    @Override
    public void insertarElemento(Elemento elemento) throws ServicesException {
        try{
            elementoDAO.save(elemento);
        }catch(PersistenceException ex) {
            throw new ServicesException("Insert error:"+ex.getLocalizedMessage(), ex);
        }
        
   
    }
}
