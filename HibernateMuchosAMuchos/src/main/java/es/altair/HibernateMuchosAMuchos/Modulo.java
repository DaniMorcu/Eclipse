package es.altair.HibernateMuchosAMuchos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="modulos")
public class Modulo implements Serializable{

	@Id
	@Column(name="idModulos")
	private Integer idModulo;
	private String nombre;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="modulos")
	private Set<Profesor> profesores = new HashSet<Profesor>();
	
	public Modulo() {
		super();
	}

	public Modulo(Integer idModulo, String name) {
		super();
		this.idModulo = idModulo;
		this.nombre = name;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", name=" + nombre + ", profesores=" + profesores + "]";
	}
	
	
	
}
