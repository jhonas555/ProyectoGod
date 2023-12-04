package logico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


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

	    public void agendaCita(String id, Paciente paciente, Doctor doctor, Date fecha) {
	        
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
	        //pendiente generar id unico
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