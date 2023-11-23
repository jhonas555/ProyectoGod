package logico;

import java.util.Date;

public class Doctor extends Persona {

	
	public Doctor(String id, String password, String cedula, String nombre, String apellido, Date fechaNacimiento,
			String telefono, String correoElectronico) {
		super(id, password, cedula, nombre, apellido, fechaNacimiento, telefono, correoElectronico);

	}
	private String numeroLicenciaMedica;
	private String Especialidad;
	
	
	public String getNumeroLicenciaMedica() {
		return numeroLicenciaMedica;
	}
	public void setNumeroLicenciaMedica(String numeroLicenciaMedica) {
		this.numeroLicenciaMedica = numeroLicenciaMedica;
	}
	public String getEspecialidad() {
		return Especialidad;
	}
	public void setEspecialidad(String especialidad) {
		Especialidad = especialidad;
	}
}
