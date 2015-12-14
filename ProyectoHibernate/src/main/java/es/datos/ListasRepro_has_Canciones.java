package es.datos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="listareprod_has_canciones")
public class ListasRepro_has_Canciones implements Serializable{

	@Id
	private Integer id_lista_genero;
	
	
	private Integer id_listareprod;
	
	
	private Integer id_cancion;
	
	
	private Integer posicion;
	
	public ListasRepro_has_Canciones() {
		super();
	}
	public ListasRepro_has_Canciones(Integer id_lista_genero, Integer id_listareprod, Integer id_cancion,
			Integer posicion) {
		super();
		this.id_lista_genero = id_lista_genero;
		this.id_listareprod = id_listareprod;
		this.id_cancion = id_cancion;
		this.posicion = posicion;
	}
	public Integer getId_lista_genero() {
		return id_lista_genero;
	}
	public void setId_lista_genero(Integer id_lista_genero) {
		this.id_lista_genero = id_lista_genero;
	}
	public Integer getId_listareprod() {
		return id_listareprod;
	}
	public void setId_listareprod(Integer id_listareprod) {
		this.id_listareprod = id_listareprod;
	}
	public Integer getId_cancion() {
		return id_cancion;
	}
	public void setId_cancion(Integer id_cancion) {
		this.id_cancion = id_cancion;
	}
	public Integer getPosicion() {
		return posicion;
	}
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	@Override
	public String toString() {
		return "ListasRepro_has_Canciones [id_lista_genero=" + id_lista_genero + ", id_listareprod=" + id_listareprod
				+ ", id_cancion=" + id_cancion + ", posicion=" + posicion + "]";
	}
	
	
}
