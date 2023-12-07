package logico;

import java.io.EOFException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Clinica implements Serializable{
	
	private static final long serialVersionUID = 5307172532851770925L;

	private ArrayList<Vacuna>lasVacunas;
	private ArrayList<Vivienda>lasViviendas;
	private ArrayList<Cita>lasCitas;
	private ArrayList<Enfermedad>lasEnfermedades;
	private ArrayList<Persona>lasPersonas;
	private static int idVacunas = 1;
	private static int idViviendas = 1;
	private static int idCitas = 1;
	private static int idEnfermedades = 1;
	private static int idPersonas = 1;
	private static Clinica clinica = null;
	
	public Clinica() {
		super();
		this.lasVacunas = new ArrayList<>();
		this.lasViviendas = new ArrayList<>();
		this.lasCitas = new ArrayList<>();
		this.lasEnfermedades = new ArrayList<>();
		this.lasPersonas = new ArrayList<>();
	}
	
	

	public static Clinica getInstance() {
		if(clinica == null) {
			clinica = new Clinica();
		}
		cargarEnfermedadesDesdeArchivo();
		return clinica;
	}
	
	public static void cargarEnfermedadesDesdeArchivo() {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enfermedades.dat"))) {
	        ArrayList<Enfermedad> loadedEnfermedades = (ArrayList<Enfermedad>) ois.readObject();
	        if (loadedEnfermedades != null && !loadedEnfermedades.isEmpty()) {
	            clinica.lasEnfermedades = loadedEnfermedades;

	            
	            int maxId = loadedEnfermedades.stream()
	                    .map(enfermedad -> extractId(enfermedad.getId()))
	                    .max(Integer::compare)
	                    .orElse(0);

	            
	            idEnfermedades = maxId + 1;
	        } else {
	            clinica.lasEnfermedades = new ArrayList<>();
	        }
	    } catch (FileNotFoundException fileNotFoundException) {
	        
	        clinica.lasEnfermedades = new ArrayList<>();
	    } catch (EOFException e) {
	        
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	private static int extractId(String id) {
	    try {
	        return Integer.parseInt(id);
	    } catch (NumberFormatException e) {
	        return 0;
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
	public static int getIdVacunas() {
		return idVacunas;
	}
	public static int getIdViviendas() {
		return idViviendas;
	}
	public static int getIdCitas() {
		return idCitas;
	}
	public static int getIdEnfermedades() {
		return idEnfermedades;
	}
	public static int getIdPersonas() {
		return idPersonas;
	}


	public void agregarEnfermedad(Enfermedad enfermedad) {
	    
	    enfermedad.setId(String.valueOf(idEnfermedades++));

	    lasEnfermedades.add(enfermedad);

	    
	    guardarEnfermedadesEnArchivo();
	}

	public void eliminarEnfermedad(String id) {
	    
	    lasEnfermedades.removeIf(enfermedad -> enfermedad.getId().equals(id));

	   
	    guardarEnfermedadesEnArchivo();
	}
	
	public void actualizarEnfermedad(String id, Enfermedad nuevaEnfermedad) {
	    for (Enfermedad enfermedad : lasEnfermedades) {
	        if (enfermedad.getId().equals(id)) {
	            // Update the existing Enfermedad with the new one
	            enfermedad.setNombre(nuevaEnfermedad.getNombre());
	            enfermedad.setDescripcion(nuevaEnfermedad.getDescripcion());

	            
	            break;
	        }
	    }
	    
	    guardarEnfermedadesEnArchivo();
	}

	private void guardarEnfermedadesEnArchivo() {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enfermedades.dat"))) {
	        oos.writeObject(lasEnfermedades);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	/*
    public void actualizarEnfermedad(String id, Enfermedad nuevaEnfermedad) {
        ArrayList<Enfermedad> enfermedades = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enfermedades.dat"))) {
            Enfermedad enfermedad;
            while ((enfermedad = (Enfermedad) ois.readObject()) != null) {
                if (enfermedad.getId().equals(id)) {
                    enfermedades.add(nuevaEnfermedad);
                } else {
                    enfermedades.add(enfermedad);
                }
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enfermedades.dat"))) {
            for (Enfermedad enfermedad : enfermedades) {
                oos.writeObject(enfermedad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
	
	public Enfermedad buscarEnfermedadPorId(String id) {
		for (Enfermedad enfermedad : lasEnfermedades) {
			if(enfermedad.getId().equalsIgnoreCase(id))
				return enfermedad;
		}
		return null;
	}
	
	public void agregarVacuna(Vacuna vacuna) {
		lasVacunas.add(vacuna);
		idVacunas++;
		
		try (FileOutputStream v = new FileOutputStream("lasVacunas.dat");
		         ObjectOutputStream oos = new ObjectOutputStream(v)) {

		        oos.writeInt(lasVacunas.size());

		        for (Vacuna p : lasVacunas) {
		            oos.writeObject(p);
		        }

		    } catch (IOException p) {
		        p.printStackTrace();
		    }
	}
	

	public void eliminarVacunas(Vacuna vacuna) {
		lasVacunas.remove(vacuna);
	}
	
	public Vacuna buscarVacunaPorNumeroLote(String numeroLote) {
		for (Vacuna vacuna : lasVacunas) {
			if(vacuna.getNumeroLote().equalsIgnoreCase(numeroLote))
				return vacuna;
		}
		return null;
	}
	
	
	public class SistemaCitasArchivo {

	    private String archivoCitas = "citas.dat";

	    public void agregarCita(Paciente paciente, Doctor doctor, Date fecha) throws Exception {
	        Cita cita = new Cita(paciente, doctor, fecha);
	        
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoCitas, true));
	        oos.writeObject(cita);
	        oos.close();
	    }

	    public void cancelarCita(Cita cita) throws Exception {
	        ArrayList<Cita> citas = leerCitas();
	        citas.remove(cita);
	        
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoCitas)); 
	        for(Cita c: citas) {
	            oos.writeObject(c);
	        }
	        oos.close();
	    }   

	    private ArrayList<Cita> leerCitas() throws Exception {
	        ArrayList<Cita> citas = new ArrayList<>();
	        
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoCitas));
	        while(true) {
	            try {
	                Cita cita = (Cita) ois.readObject(); 
	                citas.add(cita);
	    	        idCitas++;
	            } catch (EOFException e) {
	                break;
	            }
	        }
	        ois.close();
	        
	        return citas;
	    }

	}
	
	public class SistemaConsultasArchivo {

	    private String archivoConsultas = "consultas.dat";
	    
	    public void agregarConsulta(Consulta consulta) throws Exception {
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoConsultas, true)); 
	        oos.writeObject(consulta);
	        oos.close();
	    }
	    
	    public ArrayList<Consulta> obtenerConsultasPaciente(Paciente paciente) throws Exception {
	        ArrayList<Consulta> consultas = leerConsultas();
	        
	        ArrayList<Consulta> consultasPaciente = new ArrayList<>();
	        for(Consulta c: consultas) {
	            if(c.getPaciente().equals(paciente)) {
	                consultasPaciente.add(c);
	            }
	        }   
	        return consultasPaciente;
	    }
	    
	    private ArrayList<Consulta> leerConsultas() throws Exception {
	        ArrayList<Consulta> consultas = new ArrayList<>();
	        
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoConsultas)); 
	        while(true) {
	            try {
	                Consulta consulta = (Consulta) ois.readObject();
	                consultas.add(consulta); 
	            } catch(EOFException e) {
	                break;
	            }
	        }
	        ois.close();
	        
	        return consultas;
	    }  
	}
	
	public class SistemaViviendasArchivo {

	    private String archivoViviendas = "viviendas.dat";
	    
	    public void agregarVivienda(Vivienda vivienda) throws Exception {
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoViviendas, true));
	        oos.writeObject(vivienda);
	        oos.close();
	    }
	    
	    public Vivienda buscarViviendaPorId(String id) throws Exception {
	        ArrayList<Vivienda> viviendas = leerViviendas();
	        
	        for(Vivienda v : viviendas) {
	            if(v.getId().equals(id)) {
	                return v;
	            }
	        }
	        
	        return null;
	    }
	    
	    private ArrayList<Vivienda> leerViviendas() throws Exception {
	        ArrayList<Vivienda> viviendas = new ArrayList<>();
	        
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoViviendas));
	        while(true) {
	            try {
	                Vivienda vivienda = (Vivienda) ois.readObject();
	                viviendas.add(vivienda);
	    	    	idViviendas++;
	            } catch(EOFException e) {
	                break;
	            }           
	        }
	        ois.close();
	        
	        return viviendas;
	    }   
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}