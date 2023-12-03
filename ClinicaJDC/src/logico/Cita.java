package logico;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cita implements Serializable{
	
	private static final long serialVersionUID = 6871317562401895570L;

	private String id;
	private Date fecha;
	private Boolean estado;
	private Paciente paciente;
	private Doctor doctor;
	
	public Cita(String id, Date fecha, Paciente paciente, Doctor doctor) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.paciente = paciente;
		this.doctor = doctor;
	}	
	
	
	public class GestorCitas {

	    private String archivo = "citas.dat";

	    public void guardarCitas(List<Cita> citas) {
	        try {
	            FileOutputStream fos = new FileOutputStream(archivo);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(citas);
	            oos.close();
	            fos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Cita> cargarCitas() {
	        List<Cita> citas = new ArrayList<>();
	        try {
	            FileInputStream fis = new FileInputStream(archivo);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            citas = (List<Cita>) ois.readObject();
	            ois.close();
	            fis.close();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return citas; 
	    }

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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
