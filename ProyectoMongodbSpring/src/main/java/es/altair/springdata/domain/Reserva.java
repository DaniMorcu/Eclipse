package es.altair.springdata.domain;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="reserva")
@TypeAlias("reserva")
public class Reserva {
	
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
	public Reserva(Reserva reserva, Jugador jugador){
		this.fecha = reserva.getFecha();
		this.precio = reserva.getPrecio();
		this.esPagada = reserva.getEsPagada();
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
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	@Override
	public String toString() {
		return "Reserva [fecha=" + fecha + ", precio=" + precio + ", esPagada=" + esPagada + ", jugador=" + jugador
				+ "]";
	}

	
	
}
