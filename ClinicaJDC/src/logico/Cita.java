package logico;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Cita implements Serializable{
	
	private static final long serialVersionUID = 6871317562401895570L;

	private String id;
	private Date fecha;
	private Boolean estado;
	private Paciente paciente;
	private Doctor doctor;
	
	public Cita(Object object, Date fecha, Paciente paciente, Doctor doctor) {
		super();
		this.id = (String) object;
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
	
	
	public class AgendaCitas {

	    private GestorCitas gestorCitas;

	    public AgendaCitas() {
	        this.gestorCitas = new GestorCitas();
	    }

	    public void agendaCita(Paciente paciente, Doctor doctor, Date fecha) {
	        
	        // crea una cita
	        Cita cita = new Cita(id, fecha, paciente, doctor); 
	        
	        // lista las citas
	        List<Cita> citas = gestorCitas.cargarCitas();
	        
	        // agrega citas
	        citas.add(cita);

	        // guarda las citas 
	        gestorCitas.guardarCitas(citas);
	        
	    }
	    
	    
	    public void cancelarCita(Cita cita) {
	        
	        List<Cita> citas = gestorCitas.cargarCitas();
	        
	        // Buscar la cita y cambiar el estado a cancelada
	        for(Cita c : citas) {
	            if(c.getId().equals(cita.getId())) {
	                c.setEstado(false);
	                break;
	            }
	        }
	        
	        gestorCitas.guardarCitas(citas);
	        
	    }
	    
	    public void actualizarCita(Cita citaNueva) {
	    
	        List<Cita> citas = gestorCitas.cargarCitas();
	        
	        // Buscar la cita vieja y actualizarla 
	        for(int i = 0; i < citas.size(); i++) {
	            Cita c = citas.get(i); 
	            if(c.getId().equals(citaNueva.getId())) {
	                citas.set(i, citaNueva); 
	                break;
	            }
	        }

	        gestorCitas.guardarCitas(citas);
	        
	    }

	    
	    private void generaId() {
	        // pendiente generar id unico
	    }

	}
	
	public class ConsultaCitas {

	    private GestorCitas gestorCitas;

	    public ConsultaCitas() {
	        this.gestorCitas = new GestorCitas();
	    }

	    public List<Cita> consultaCitas() {
	        return gestorCitas.cargarCitas(); 
	    }

	    public List<Cita> consultaCitasPaciente(Paciente paciente) {
	        List<Cita> citas = gestorCitas.cargarCitas();
	        
	        // Filtrar sólo citas del paciente
	        return citas.stream()
	                    .filter(c -> c.getPaciente().equals(paciente))
	                    .collect(Collectors.toList());
	    }
	    
	    public List<Cita> consultaCitasDoctor(Doctor doctor, Date desde, Date hasta) {
	        List<Cita> citas = gestorCitas.cargarCitas();
	        
	        // Filtrar por doctor y rango de fechas
	        return citas.stream()
	                    .filter(c -> c.getDoctor().equals(doctor)) 
	                    .filter(c -> c.getFecha().after(desde) && 
	                               c.getFecha().before(hasta))
	                    .collect(Collectors.toList()); 
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
