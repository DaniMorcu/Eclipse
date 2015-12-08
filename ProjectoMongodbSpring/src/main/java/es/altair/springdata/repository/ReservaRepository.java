package es.altair.springdata.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.Repository;

import es.altair.springdata.domain.Reserva;

public interface ReservaRepository extends Repository<Reserva, Long> {

	public Reserva findByFecha(Date fecha);
	
	public Reserva findByFechaGreaterThanAndEsPagada(Date fecha, Boolean esPagado);
	
	public List<Reserva> findByEsPagadaAndJugadorCiudad(Boolean esPagada, String ciudad);
	
	public List<Reserva> findByEsPagadaAndFechaLessThan(Boolean esPagada, Date fecha);
	
	public List<Reserva> findByPrecioIsNotNull();
	
	public List<Reserva> findByEsPagadaIs(Boolean esPagada);
	
}
