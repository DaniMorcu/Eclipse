package es.datos.bean;

public class Producto {

	private int idProducto;
	private String nombreProducto;
	private double precio;
	private String descripcion;
	private int stock;
	private int idCategoria;
	private int idEmpresa;
	
	public Producto(int idProducto, String nombreProducto, double precio, String descripcion, int stock,
			int idCategoria, int idEmpresa) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.stock = stock;
		this.idCategoria = idCategoria;
		this.idEmpresa = idEmpresa;
	}

	public Producto(String nombreProducto, double precio, String descripcion, int stock, int idCategoria,
			int idEmpresa) {
		super();
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.stock = stock;
		this.idCategoria = idCategoria;
		this.idEmpresa = idEmpresa;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", stock=" + stock + ", idCategoria=" + idCategoria + ", idEmpresa="
				+ idEmpresa + "]";
	}
	
	
	
}
