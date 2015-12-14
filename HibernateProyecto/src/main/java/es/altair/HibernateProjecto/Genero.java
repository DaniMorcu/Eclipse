package es.altair.HibernateProjecto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genero implements Serializable{

	@Id
	private Integer id_genero;
	
	private String tipo;
	
	public Genero() {
		super();
	}
	public Genero(String tipo) {
		super();
		this.tipo = tipo;
	}
	
	public Genero(Integer id_genero, String tipo) {
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
	@Override
	public String toString() {
		return "Genero [id_genero=" + id_genero + ", tipo=" + tipo + "]";
	}
	
	
}
