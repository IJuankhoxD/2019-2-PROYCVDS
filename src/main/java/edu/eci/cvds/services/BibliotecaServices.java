package edu.eci.cvds.services;




import edu.eci.cvds.entities.Recurso;
import java.util.ArrayList;
import java.util.List;


public interface BibliotecaServices {
	

    void insertarRecurso(Recurso elemento) throws ServicesException;
    List<Recurso> buscarRecurso() throws ServicesException;

 
}
