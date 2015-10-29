package es.altair.mongodb02;

public class Libro {

	private String titulo;
	private int numPag;
	private String editorial;
	private int anyoPubli;
	private String web;
	private double precio;
	
	public Libro(String titulo, int numPag, String editorial, int anyoPubli, String web, double precio) {
		super();
		this.titulo = titulo;
		this.numPag = numPag;
		this.editorial = editorial;
		this.anyoPubli = anyoPubli;
		this.web = web;
		this.precio = precio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNumPag() {
		return numPag;
	}
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getAnyoPubli() {
		return anyoPubli;
	}
	public void setAnyoPubli(int anyoPubli) {
		this.anyoPubli = anyoPubli;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", numPag=" + numPag + ", editorial=" + editorial + ", anyoPubli="
				+ anyoPubli + ", web=" + web + ", precio=" + precio + "]";
	}
	
	
}
