package es.altair;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra implements Serializable {

	@Id
	private int idCompra;
	private String fecha;
	private String hora;
	
	@ManyToOne
	@JoinColumn(name="id_Cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_Cajera")
	private Cajera cajera;
	
	@ManyToMany(mappedBy="compras")
	private Set<Producto> productos = new HashSet<Producto>();

	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compra(String fecha, String hora, Cliente cliente, Cajera cajera) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.cajera = cajera;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cajera getCajera() {
		return cajera;
	}

	public void setCajera(Cajera cajera) {
		this.cajera = cajera;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", fecha=" + fecha + ", hora=" + hora + ", cliente=" + cliente
				+ ", cajera=" + cajera + ", productos=" + productos + "]";
	}
}
