package es.datos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{

	@Id
	private Integer id_usuario;
	
	private String nombre;
	private String alias;
	private String email;
	
	@OneToMany(mappedBy="id_usuario", cascade = CascadeType.ALL)
	private List<ListaRepro> listasdereproduccion;
	
	public Usuarios() {
		super();
	}

	public Usuarios(Integer id_usuario, String nombre, String alias, String email) {
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
		return "Usuarios [id_usuario=" + id_usuario + ", nombre=" + nombre + ", alias=" + alias + ", email=" + email
				+ "]";
	}
	
	
	
}
