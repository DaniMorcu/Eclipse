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
@Table(name="cliente")
public class Cliente implements Serializable{

	@Id
	private int idCliente;
	
	private String login;
	private String pass;
	private String nombre;
	private int telefono;
	private String direccion;
	
	@OneToMany
	@JoinColumn(name="idCliente")
	@OrderColumn(name="idx")
	private List<Compra> compras;

	public Cliente() {
		super();
	}

	public Cliente(String login, String pass, String nombre, int telefono, String direccion) {
		super();
		this.login = login;
		this.pass = pass;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", login=" + login + ", pass=" + pass + ", nombre=" + nombre
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", compras=" + compras + "]";
	}
	
	
	
}
