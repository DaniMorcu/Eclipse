package datos;

import java.util.ArrayList;

public class Alumnos {

	private ArrayList<Alumno> alumnos;
	
	public Alumnos()
	{
		alumnos = new ArrayList<>();
	}
	
	public void anadir(Alumno a)
	{
		alumnos.add(a);
	}
	
	public Alumno buscaPorNombre(String nombre)
	{
		for (Alumno alumno : alumnos) {
			if(alumno.getNombre().equals(nombre))
				return alumno;
		}
		return null;
	}

	
	public Alumno buscaPorApellidos(String apellidos)
	{
		for (Alumno alumno : alumnos) {
			if(alumno.getApellidos().equals(apellidos))
				return alumno;
		}
		return null;
	}
	
	public Alumno buscaPorEdad(int edad)
	{
		for (Alumno alumno : alumnos) {
			if(alumno.getEdad() == edad)
				return alumno;
		}
		return null;
	}
	
	public Alumno buscaPorNota(float nota)
	{
		for (Alumno alumno : alumnos) {
			if(alumno.getNota() == nota)
				return alumno;
		}
		return null;
	}
	
	public Alumno buscarPatron(String patron) {
		for (Alumno alumno : alumnos) {
			if(alumno.getNombre().equals(patron) || alumno.getApellidos().equals(patron)
					|| String.valueOf(alumno.getEdad()).equals(patron)
					|| String.valueOf(alumno.getNota()).equals(patron))
				
				return alumno;
		}
		return null;
	}
	
	
}
