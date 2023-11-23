package logico;

import java.util.ArrayList;

public class Vivienda {
	public Vivienda(String id, ArrayList<Persona> lasPersonas) {
		super();
		this.id = id;
		this.lasPersonas = lasPersonas;
	}
	
	private String id;
	private ArrayList<Persona>lasPersonas;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Persona> getLasPersonas() {
		return lasPersonas;
	}
	public void setLasPersonas(ArrayList<Persona> lasPersonas) {
		this.lasPersonas = lasPersonas;
	}

}
