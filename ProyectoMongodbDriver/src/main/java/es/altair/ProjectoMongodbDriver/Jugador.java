package es.altair.ProjectoMongodbDriver;

public class Jugador {

	private String nombre;
	private String apellidos;
	private String ciudad;
	private Integer anyo_inscripcion;
	private Integer num_socio;
	
	public Jugador() {
		super();
	}
	public Jugador(String nombre, String apellidos, String ciudad, Integer anyo_inscripcion,
			Integer num_socio) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.anyo_inscripcion = anyo_inscripcion;
		this.num_socio = num_socio;
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
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Integer getAnyo_inscripcion() {
		return anyo_inscripcion;
	}
	public void setAnyo_inscripcion(Integer anyo_inscripcion) {
		this.anyo_inscripcion = anyo_inscripcion;
	}
	public Integer getNum_socio() {
		return num_socio;
	}
	public void setNum_socio(Integer num_socio) {
		this.num_socio = num_socio;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellidos=" + apellidos + ", ciudad=" + ciudad + ", anyo_inscripcion="
				+ anyo_inscripcion + ", num_socio=" + num_socio + "]";
	}

	
	
}
