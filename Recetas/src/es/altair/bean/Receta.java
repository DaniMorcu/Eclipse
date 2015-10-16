package es.altair.bean;

public class Receta {

	private int idReceta;
	private String nombre;
	private int idTipoReceta;
	private String descripcion;
	private int idUsuario;
	
	public Receta(int idReceta, String nombre, int idTipoReceta, String descripcion, int idUsuario) {
		super();
		this.idReceta = idReceta;
		this.nombre = nombre;
		this.idTipoReceta = idTipoReceta;
		this.descripcion = descripcion;
		this.idUsuario = idUsuario;
	}

	public Receta(String nombre, int idTipoReceta, String descripcion, int idUsuario) {
		super();
		this.nombre = nombre;
		this.idTipoReceta = idTipoReceta;
		this.descripcion = descripcion;
		this.idUsuario = idUsuario;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdTipoReceta() {
		return idTipoReceta;
	}

	public void setIdTipoReceta(int idTipoReceta) {
		this.idTipoReceta = idTipoReceta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}
