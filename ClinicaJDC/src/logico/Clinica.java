package logico;

import java.util.ArrayList;

public class Clinica {
	
	public Clinica(ArrayList<Vacuna> lasVacinas, ArrayList<Vivienda> lasViviendas, ArrayList<Cita> lasCitas,
			ArrayList<Enfermedad> lasEnfermedades) {
		super();
		this.lasVacinas = lasVacinas;
		this.lasViviendas = lasViviendas;
		this.lasCitas = lasCitas;
		this.lasEnfermedades = lasEnfermedades;
	}
	
	
	private ArrayList<Vacuna>lasVacinas;
	private ArrayList<Vivienda>lasViviendas;
	private ArrayList<Cita>lasCitas;
	private ArrayList<Enfermedad>lasEnfermedades;
	
	
	
	
	public ArrayList<Vacuna> getLasVacinas() {
		return lasVacinas;
	}
	public void setLasVacinas(ArrayList<Vacuna> lasVacinas) {
		this.lasVacinas = lasVacinas;
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
	
	

}
