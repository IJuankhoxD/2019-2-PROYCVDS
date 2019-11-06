package edu.eci.cvds.services;




import edu.eci.cvds.entities.Elemento;
import java.util.ArrayList;
import java.util.List;


public interface BibliotecaServices {
	

    void insertarElemento(Elemento elemento) throws ServicesException;
    List<Elemento> buscarElementos() throws ServicesException;

 
}
