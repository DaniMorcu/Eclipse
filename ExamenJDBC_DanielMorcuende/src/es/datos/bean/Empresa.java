package es.datos.bean;

public class Empresa {

	private int idEmpresa;
	private String nombreEmpresa;
	private String cif;
	private String email;
	private String ciudad;
	private int activado;
	
	public Empresa(int idEmpresa, String nombreEmpresa, String cif, String email, String ciudad, int activado) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.cif = cif;
		this.email = email;
		this.ciudad = ciudad;
		this.activado = activado;
	}

	public Empresa(String nombreEmpresa, String cif, String email, String ciudad, int activado) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.cif = cif;
		this.email = email;
		this.ciudad = ciudad;
		this.activado = activado;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getActivado() {
		return activado;
	}

	public void setActivado(int activado) {
		this.activado = activado;
	}

	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", cif=" + cif + ", email="
				+ email + ", ciudad=" + ciudad + ", activado=" + activado + "]";
	}
	
}
