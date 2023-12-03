package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Vivienda implements Serializable {

	private static final long serialVersionUID = 7998444807365673173L;
	
	private String id;
	private ArrayList<Persona>lasPersonas;

	public Vivienda(String id, ArrayList<Persona> lasPersonas) {
		super();
		this.id = id;
		this.lasPersonas = lasPersonas;
	}
		
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
