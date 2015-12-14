package es.altair.HibernateMuchosAMuchos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor implements Serializable{

	@Id
	private Integer idProfesor;
	private String nombre;
	private String apellidos;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="profesormodulo", joinColumns={@JoinColumn(name="idProfe")}, inverseJoinColumns={@JoinColumn(name="idModu")})
	private Set<Modulo> modulos = new HashSet<Modulo>();
	
	public Profesor() {
		super();
	}

	public Profesor(Integer idProfesor, String nombre, String apellidos) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Set<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Profesor [idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", modulos="
				+ modulos + "]";
	}
	
	
	
}
