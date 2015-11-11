package es.altair.springdata.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//	1.	
@Document
public class Direccion {
	
	@Id
	private long id;
	
	private String calle;
	
	private String ciudad;

	public Direccion(long id, String calle, String ciudad) {
		super();
		this.id = id;
		this.calle = calle;
		this.ciudad = ciudad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad + "]";
	}
	
	
}
