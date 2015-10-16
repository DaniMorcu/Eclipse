package es.altair.bean;

public class Usuario {

	private int idUsuario;
	private String nombre;
	private String apellidos;
	private String login;
	private String password;
	private String email;
	private int tipo_acceso;
	private int activacion;

	public Usuario(int idUsuario, String nombre, String apellidos, String login, String password, String email,
			int tipo_acceso, int activacion) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.login = login;
		this.password = password;
		this.email = email;
		this.tipo_acceso = tipo_acceso;
		this.activacion = activacion;
	}
	
	public Usuario(String nombre, String apellidos, String login, String password, String email, int tipo_acceso,
			int activacion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.login = login;
		this.password = password;
		this.email = email;
		this.tipo_acceso = tipo_acceso;
		this.activacion = activacion;
	}



	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTipo_acceso() {
		return tipo_acceso;
	}

	public void setTipo_acceso(int tipo_acceso) {
		this.tipo_acceso = tipo_acceso;
	}

	public int getActivacion() {
		return activacion;
	}

	public void setActivacion(int activacion) {
		this.activacion = activacion;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", login="
				+ login + ", password=" + password + ", email=" + email + ", tipo_acceso=" + tipo_acceso
				+ ", activacion=" + activacion + "]";
	}

}
