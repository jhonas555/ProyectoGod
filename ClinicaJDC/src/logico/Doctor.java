package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Doctor extends Persona {

	private static final long serialVersionUID = -4029156010399063867L;
	
	private String numeroLicenciaMedica;
	private String Especialidad;

	public Doctor(String id, String password, String cedula, String nombre, String apellido, Date fechaNacimiento,
			String telefono, String correoElectronico) {
		super(id, password, cedula, nombre, apellido, fechaNacimiento, telefono, correoElectronico);
	}	
	


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
	
    public void guardarDatos() throws IOException {
        File archivo = new File("doctores.dat");
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }
    
    public static Doctor leerDatos() throws IOException, ClassNotFoundException {
        File archivo = new File("doctores.dat"); 
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Doctor doctor = (Doctor) ois.readObject(); 
        ois.close();
        return doctor;
    }
}
