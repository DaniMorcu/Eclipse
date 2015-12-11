package es.altair;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable {

	@Id
	private int idProducto;
	
	private String nombre;
	private Double precio;
	
	//	Relacion NM
	@ManyToMany
	@JoinTable(name="productocompra", joinColumns={@JoinColumn(name="id_Producto")}, inverseJoinColumns = {@JoinColumn(name = "id_Compra")})
	private Set<Compra> compras = new HashSet<Compra>();

	public Producto() {
		super();
	}

	public Producto(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", compras="
				+ compras + "]";
	}
	
	
}
