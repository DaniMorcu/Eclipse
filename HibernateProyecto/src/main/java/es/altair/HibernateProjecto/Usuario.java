package es.altair.HibernateProjecto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable{

	@Id
	private Integer id_usuario;
	private String nombre;
	private String alias;
	private String email;
	
	public Usuario() {
		super();
	}
	public Usuario(String nombre, String alias, String email) {
		super();
		this.nombre = nombre;
		this.alias = alias;
		this.email = email;
	}
	
	public Usuario(Integer id_usuario, String nombre, String alias, String email) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.alias = alias;
		this.email = email;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", alias=" + alias + ", email=" + email
				+ "]";
	}
	
	
}
