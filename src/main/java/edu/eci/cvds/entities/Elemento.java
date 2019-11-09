package edu.eci.cvds.entities;


public class Elemento {
    
    private int id;
    private boolean averiado;
    private String ubicacion;
    private boolean disponible;
    private String nombre;
    private int capacidad;
    private ElementoTipo tipo;
    
    
    
    public Elemento(int id, boolean disponible,String ubicacion, String nombre, ElementoTipo tipo) {
            super();
            this.id = id;
            this.ubicacion = ubicacion;
            this.disponible = disponible;   
            this.averiado = false;
            this.nombre = nombre;
            this.tipo = tipo;
	}
   
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public boolean getDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

        public String getUbicacion(){
            return ubicacion;
        }
	public void setUbicacion(String ubicacion){
            this.ubicacion = ubicacion;
        }
        
        public boolean getAveriado(){
            return averiado;
        }
        public void setAvereiado(boolean averiado){
            this.averiado = averiado;
        }
        public ElementoTipo getElementoTipo(){
            return tipo;
        }
        public void setElementoTipo(ElementoTipo tipo){
            this.tipo = tipo;
        }

	@Override
    public String toString() {
        return "Elemento { id: "+id+", ubicacion: "+ubicacion+", nombre: "+nombre+", disponible: "+disponible+" }";
    }
    
    
    
}