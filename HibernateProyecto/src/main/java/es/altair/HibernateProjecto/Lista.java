package es.altair.HibernateProjecto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="lista")
public class Lista implements Serializable {

	@Id
	private Integer id_lista;
	
	private String nombre;
	private Integer id_usuario;
	private String descripcion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="lista_cancion", joinColumns={@JoinColumn(name="id_lista")}, inverseJoinColumns={@JoinColumn(name="id_cancion")})
	private Set<Cancion> canciones = new HashSet<Cancion>();
	
	public Lista() {
		super();
	}
	public Lista(String nombre, Integer id_usuario, String descripcion) {
		super();
		this.nombre = nombre;
		this.id_usuario = id_usuario;
		this.descripcion = descripcion;
	}
	
	
	
	public Lista(Integer id_lista, String nombre, Integer id_usuario, String descripcion) {
		super();
		this.id_lista = id_lista;
		this.nombre = nombre;
		this.id_usuario = id_usuario;
		this.descripcion = descripcion;
		this.canciones = canciones;
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
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public Set<Cancion> getCanciones() {
		return canciones;
	}
	public void setCanciones(Set<Cancion> canciones) {
		this.canciones = canciones;
	}
	@Override
	public String toString() {
		return "Lista [id_lista=" + id_lista + ", nombre=" + nombre + ", id_usuario=" + id_usuario + ", descripcion="
				+ descripcion + "]";
	}
	
	
	
}
