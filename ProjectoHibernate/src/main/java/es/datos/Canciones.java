package es.datos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="canciones")
public class Canciones implements Serializable{

	@Id
	private Integer id_cancion;
	private String titulo;
	private String artista;
	
	@ManyToOne
	@JoinColumn(name="id_genero")
	private Generos id_genero;
	
	public Canciones() {
		super();
	}

	public Canciones(Integer id_cancion, String titulo, String artista, Generos id_genero) {
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
	public Generos getId_genero() {
		return id_genero;
	}
	public void setId_genero(Generos id_genero) {
		this.id_genero = id_genero;
	}
	@Override
	public String toString() {
		return "Canciones [id_cancion=" + id_cancion + ", titulo=" + titulo + ", artista=" + artista + ", id_genero="
				+ id_genero + "]";
	}
	
	
}
