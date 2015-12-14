package es.altair.HibernateProjecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cancion")
public class Cancion implements Serializable {

	@Id
	private Integer id_cancion;
	private String titulo;
	private String artista;
	private Integer id_genero;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="canciones")
	private List<Lista> listas = new ArrayList<Lista>();
	public Cancion() {
		super();
	}
	public Cancion(String titulo, String artista, Integer id_genero) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.id_genero = id_genero;
	}
	public Cancion(Integer id_cancion, String titulo, String artista, Integer id_genero) {
		super();
		this.id_cancion = id_cancion;
		this.titulo = titulo;
		this.artista = artista;
		this.id_genero = id_genero;
	}
	public Integer getId_cancion() {
		return id_cancion;
	}
	public void setId_cancion(Integer id_cancion) {
		this.id_cancion = id_cancion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public Integer getId_genero() {
		return id_genero;
	}
	public void setId_genero(Integer id_genero) {
		this.id_genero = id_genero;
	}
	
	
	public List<Lista> getListas() {
		return listas;
	}
	public void setListas(List<Lista> listas) {
		this.listas = listas;
	}
	@Override
	public String toString() {
		return "Cancion [id_cancion=" + id_cancion + ", titulo=" + titulo + ", artista=" + artista + ", id_genero="
				+ id_genero + "]";
	}
	
	
	
}
