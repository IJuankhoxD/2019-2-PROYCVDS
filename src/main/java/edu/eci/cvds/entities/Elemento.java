package edu.eci.cvds.entities;


public class Elemento {
    
    private int id;
    private int valor;
    private boolean disponible;
    
    
    
    public Elemento(int id, int valor, boolean disponible) {
            super();
            this.id = -1;
            this.valor = valor;
            this.disponible = disponible;   
	}
   
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public boolean getDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	


	@Override
    public String toString() {
        return "Elemento { id: "+id+", valor: "+valor+", disponible: "+disponible+" }";
    }
    
    
    
}