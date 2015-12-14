package es.altair.springdata.repository;

import org.springframework.data.repository.Repository;

import es.altair.springdata.domain.Jugador;

public interface JugadorRepository extends Repository<Jugador, Long> {

	public Jugador findByNombre(String nombre);
}
