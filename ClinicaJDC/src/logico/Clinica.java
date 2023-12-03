package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Clinica implements Serializable{
	
	private static final long serialVersionUID = 5307172532851770925L;

	private ArrayList<Vacuna>lasVacunas;
	private ArrayList<Vivienda>lasViviendas;
	private ArrayList<Cita>lasCitas;
	private ArrayList<Enfermedad>lasEnfermedades;
	private ArrayList<Persona>lasPersonas;
	
	public Clinica(ArrayList<Vacuna> lasVacunas, ArrayList<Vivienda> lasViviendas, ArrayList<Cita> lasCitas,
			ArrayList<Enfermedad> lasEnfermedades, ArrayList<Persona> lasPersonas) {
		super();
		this.lasVacunas = lasVacunas;
		this.lasViviendas = lasViviendas;
		this.lasCitas = lasCitas;
		this.lasEnfermedades = lasEnfermedades;
		this.lasPersonas = lasPersonas;
	}

	
	public ArrayList<Vacuna> getLasVacunas() {
		return lasVacunas;
	}
	public void setLasVacunas(ArrayList<Vacuna> lasVacunas) {
		this.lasVacunas = lasVacunas;
	}
	public ArrayList<Vivienda> getLasViviendas() {
		return lasViviendas;
	}
	public void setLasViviendas(ArrayList<Vivienda> lasViviendas) {
		this.lasViviendas = lasViviendas;
	}
	public ArrayList<Cita> getLasCitas() {
		return lasCitas;
	}
	public void setLasCitas(ArrayList<Cita> lasCitas) {
		this.lasCitas = lasCitas;
	}
	public ArrayList<Enfermedad> getLasEnfermedades() {
		return lasEnfermedades;
	}
	public void setLasEnfermedades(ArrayList<Enfermedad> lasEnfermedades) {
		this.lasEnfermedades = lasEnfermedades;
	}
	public ArrayList<Persona> getLasPersonas() {
		return lasPersonas;
	}
	public void setLasPersonas(ArrayList<Persona> lasPersonas) {
		this.lasPersonas = lasPersonas;
	}	
}