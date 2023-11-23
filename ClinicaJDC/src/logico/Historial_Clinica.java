package logico;

import java.util.ArrayList;

public class Historial_Clinica {
	
	private String id;
	private ArrayList<Consulta> lasConsultas;
	
	public Historial_Clinica(String id, ArrayList<Consulta> lasConsultas) {
		super();
		this.id = id;
		this.lasConsultas = lasConsultas;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Consulta> getLasConsultas() {
		return lasConsultas;
	}
	public void setLasConsultas(ArrayList<Consulta> lasConsultas) {
		this.lasConsultas = lasConsultas;
	}
}
