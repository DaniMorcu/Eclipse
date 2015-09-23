package datos;

import java.util.ArrayList;

public class Alumnos {

	private ArrayList<Alumno> alumnos = null;
	
	public Alumnos()
	{
		alumnos = new ArrayList<>();
	}
	
	public void anadirAlumno(Alumno a)
	{
		alumnos.add(a);
	}
	
	public void buscaPorNombre(String nombre)
	{
		if(alumnos.contains(nombre))
			System.out.println(nombre.toString());
		else 
			System.out.println("null");
	}
	
	
	
}
