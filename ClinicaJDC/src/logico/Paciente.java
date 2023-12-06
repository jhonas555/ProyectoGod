package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Persona {

	private static final long serialVersionUID = -5408621671738297914L;
	private String numeroSeguro;
	private boolean Sano;
	private Historial_Clinica historial;
	private ArrayList<Vacuna> lasVacunas;
	
	public Paciente(String id, String password, String cedula, String nombre, String apellido, Date fechaNacimiento,
			String telefono, String correoElectronico) {
		super(id, password, cedula, nombre, apellido, fechaNacimiento, telefono, correoElectronico);
	}
	
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
	
    public void guardarDatos() throws IOException {

        File archivo = new File("pacientes.dat");
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();

    }

    public static Paciente leerDatos() throws IOException, ClassNotFoundException {

       File archivo = new File("pacientes.dat");
       FileInputStream fis = new FileInputStream(archivo);
       ObjectInputStream ois = new ObjectInputStream(fis);
       
       Paciente paciente = (Paciente) ois.readObject();
       ois.close();
       
       return paciente;

    }

}
