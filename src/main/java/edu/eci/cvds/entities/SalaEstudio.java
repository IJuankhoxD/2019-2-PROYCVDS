package edu.eci.cvds.entities;


public class SalaEstudio extends Elemento {
    
    private int capacidad;
    private int tableros;
    private int sillas;
    private int marcador;
    private int borrador;
    
    
    
    public SalaEstudio(int id, int valor, boolean disponible,int capacidad, int tableros, int sillas,int marcador, int borrador) {
		super(id,valor, disponible);
		
	}
   
	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public int getTableros() {
		return tableros;
	}


	public void setTableros(int tableros) {
		this.tableros = tableros;
	}


	public int getSillas() {
		return sillas;
	}


	public void setSillar(int sillas) {
		this.sillas = sillas;
	}
        
        public int getMarcador(){
            return marcador;
        }
        public void setMarcador(int marcador){
            this.marcador = marcador;
        }
        
	


    @Override
    public String toString() {
        return "Sala de estudio { id: "+super.getId()+", valor: "+super.getValor()+", disponible: "+super.getDisponible()+", Capacidad: "+capacidad+" }";
    }
    
    
    
}