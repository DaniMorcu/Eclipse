package es.altair;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="cajera")
public class Cajera implements Serializable{

	@Id
	private int idCajera;
	
	private String nombre;
	private int numCaja;
	
	//	Una cajera tiene muchas compras por lo que creamos una lista con las compras
	@OneToMany
	@JoinColumn(name="idCajera")
	@OrderColumn(name="idl")	//	Para establecer un orden de la lista de la compra y guardarla en el campo de idl de la bbdd
	private List<Compra> compras;

	
	
	public Cajera() {
		super();
	}
	
	public Cajera(String nombre, int numCaja) {
		super();
		this.nombre = nombre;
		this.numCaja = numCaja;
	}

	public int getIdCajera() {
		return idCajera;
	}

	public void setIdCajera(int idCajera) {
		this.idCajera = idCajera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumCaja() {
		return numCaja;
	}

	public void setNumCaja(int numCaja) {
		this.numCaja = numCaja;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	
	
	
}
