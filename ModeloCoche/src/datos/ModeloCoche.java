package datos;

public class ModeloCoche {

	private int anyo;
	private int velocidad;
	private float precio;
	private String nombre;
	private String marca;
	
	public ModeloCoche(int anyo, int velocidad, float precio, String nombre, String marca) {
		super();
		this.anyo = anyo;
		this.velocidad = velocidad;
		this.precio = precio;
		this.nombre = nombre;
		this.marca = marca;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "ModeloCoche [anyo=" + anyo + ", velocidad=" + velocidad + ", precio=" + precio + ", nombre=" + nombre
				+ ", marca=" + marca + "]";
	}
	
	
}
