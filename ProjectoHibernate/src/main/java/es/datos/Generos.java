package es.datos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="generos")
public class Generos implements Serializable{

	@Id
	private Integer id_genero;
	
	private String tipo;
	
	@OneToMany(mappedBy="id_cancion", cascade=CascadeType.ALL)
	private List<Canciones> lista_canciones;
	
	public Generos() {
		super();
	}
	public Generos(Integer id_genero, String tipo) {
		super();
		this.id_genero = id_genero;
		this.tipo = tipo;
	}
	public Integer getId_genero() {
		return id_genero;
	}
	public void setId_genero(Integer id_genero) {
		this.id_genero = id_genero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	public List<Canciones> getLista_canciones() {
		return lista_canciones;
	}
	public void setLista_canciones(List<Canciones> lista_canciones) {
		this.lista_canciones = lista_canciones;
	}
	@Override
	public String toString() {
		return "Generos [id_genero=" + id_genero + ", tipo=" + tipo + "]";
	}
	
	
}
