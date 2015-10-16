package es.altair.bean;

public class Alumno {

	private int idalumno;
	private String nombre;
	private String apellidos;
	private int edad;
	private int matriculado;
	
	public Alumno(int idalumno, String nombre, String apellidos, int edad, int matriculado) {
		super();
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.matriculado = matriculado;
	}

	public Alumno(String nombre, String apellidos, int edad, int matriculado) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.matriculado = matriculado;
	}

	public int getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getMatriculado() {
		return matriculado;
	}
	public void setMatriculado(int matriculado) {
		this.matriculado = matriculado;
	}
	@Override
	public String toString() {
		return "Alumno [idalumno=" + idalumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", matriculado=" + matriculado + "]";
	}
	
	
	
}
