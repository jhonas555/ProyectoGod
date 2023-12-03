package logico;

import java.io.Serializable;
import java.util.Date;

public class Cita implements Serializable{
	
	private static final long serialVersionUID = 6871317562401895570L;

	private String id;
	private Date fecha;
	private Paciente paciente;
	private Doctor doctor;
	
	public Cita(String id, Date fecha, Paciente paciente, Doctor doctor) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.paciente = paciente;
		this.doctor = doctor;
	}	

	public Cita() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
