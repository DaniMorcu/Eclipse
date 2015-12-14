package es.altair.ProjectoMongodbDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

	//	Con Mongo jugamos con Date, pero en la aplicacion lo convertimos a Calendar
	private Date fecha;
	private Double precio;
	private Boolean esPagada;
	private Jugador jugador;
	
	public Reserva() {
		super();
	}
	public Reserva(Date fecha, Double precio, Boolean esPagada) {
		super();
		this.fecha = fecha;
		this.precio = precio;
		this.esPagada = esPagada;
	}
	public Reserva(Date fecha, Double precio, Boolean esPagada, Jugador jugador) {
		super();
		this.fecha = fecha;
		this.precio = precio;
		this.esPagada = esPagada;
		this.jugador = jugador;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Boolean getEsPagada() {
		return esPagada;
	}
	public void setEsPagada(Boolean esPagada) {
		this.esPagada = esPagada;
	}
	@Override
	public String toString() {
		
		SimpleDateFormat formatearDate = new SimpleDateFormat("dd/MM/yyyy");
	    
		return "Reserva [fecha=" + formatearDate.format(fecha.getTime()) + ", precio=" + precio + ", esPagada=" + esPagada + ", jugador=" + jugador
				+ "]";
	}

	
		
}
