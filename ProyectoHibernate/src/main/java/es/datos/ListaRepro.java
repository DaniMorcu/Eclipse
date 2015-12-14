package es.datos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="listasreprod")
public class ListaRepro implements Serializable{

	@Id
	private Integer id_lista;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="")
	private Usuarios id_usuario;
	
	private String descripcion;
	

	
	public ListaRepro() {
		super();
	}

	public ListaRepro(Integer id_lista, String nombre, Usuarios id_usuario, String descripcion) {
		super();
		this.id_lista = id_lista;
		this.nombre = nombre;
		this.id_usuario = id_usuario;
		this.descripcion = descripcion;
	}

	public Integer getId_lista() {
		return id_lista;
	}

	public void setId_lista(Integer id_lista) {
		this.id_lista = id_lista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuarios getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuarios id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ListaRepro [id_lista=" + id_lista + ", nombre=" + nombre + ", id_usuario=" + id_usuario
				+ ", descripcion=" + descripcion + "]";
	}
	
	
}
