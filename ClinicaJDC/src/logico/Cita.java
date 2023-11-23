package logico;

import java.util.Date;

public class Cita {
	
	public Cita(String id, Date fecha, Paciente paciente, Doctor doctor) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.paciente = paciente;
		this.doctor = doctor;
	}


	private String id;
	private Date fecha;
	private Paciente paciente;
	private Doctor doctor;
	

	public Cita() {
		// TODO Auto-generated constructor stub
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
