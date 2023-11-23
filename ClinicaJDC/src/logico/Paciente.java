package logico;

import java.util.ArrayList;

public class Paciente extends Persona {

	
	private String numeroSeguro;
	private boolean Sano;
	private Historial_Clinica historial;
	private ArrayList<Vacuna> lasVacunas;
	
	public String getNumeroSeguro() {
		return numeroSeguro;
	}
	public void setNumeroSeguro(String numeroSeguro) {
		this.numeroSeguro = numeroSeguro;
	}
	public boolean isSano() {
		return Sano;
	}
	public void setSano(boolean sano) {
		Sano = sano;
	}
	public Historial_Clinica getHistorial() {
		return historial;
	}
	public void setHistorial(Historial_Clinica historial) {
		this.historial = historial;
	}
	public ArrayList<Vacuna> getLasVacunas() {
		return lasVacunas;
	}
	public void setLasVacunas(ArrayList<Vacuna> lasVacunas) {
		this.lasVacunas = lasVacunas;
	}
	

}
