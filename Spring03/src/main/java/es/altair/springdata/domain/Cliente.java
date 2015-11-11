package es.altair.springdata.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//	1. 	Anotaciones. Document especifica que es un documento (una coleccion de mongo) y
//	lo llamamos "clientes"
@Document(collection="clientes")
//	2.	Para que aparezca el nombre de la clase cliente y no es.altair...cleinte
@TypeAlias("cliente")
public class Cliente {

	@Id
	private long id;
	
	private String nombre;
	
	private String empresa;
	
	//	3.	En el documento se llamará edad (en mongoDB)
	@Field("edad")
	private int edadDelCliente;
	
	private double facturacion;
	
	private Direccion direccion;

	public Cliente(long id, String nombre, String empresa, int edadDelCliente, double facturacion,
			Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.empresa = empresa;
		this.edadDelCliente = edadDelCliente;
		this.facturacion = facturacion;
		this.direccion = direccion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getEdadDelCliente() {
		return edadDelCliente;
	}

	public void setEdadDelCliente(int edadDelCliente) {
		this.edadDelCliente = edadDelCliente;
	}

	public double getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(double facturacion) {
		this.facturacion = facturacion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", empresa=" + empresa + ", edadDelCliente="
				+ edadDelCliente + ", facturacion=" + facturacion + ", direccion=" + direccion + "]";
	}
	
	
	
}
