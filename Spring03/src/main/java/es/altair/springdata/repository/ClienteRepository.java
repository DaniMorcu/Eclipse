package es.altair.springdata.repository;



import java.util.List;

import org.springframework.data.repository.Repository;

import es.altair.springdata.domain.Cliente;
import es.altair.springdata.domain.Direccion;

public interface ClienteRepository extends Repository<Cliente, Long> {
	
	public Cliente findByNombre(String nombre);
	
	public Cliente findByNombreAndEmpresa(String nombre, String empresa);
	
	public List<Cliente> findByEdadDelClienteGreaterThan(int edadDelCliente);
	
	public List<Cliente> findByDireccion(Direccion direccion);
	
	//	Todos los clientes de una misma calle
	public List<Cliente> findByDireccionCalle(String calle);
	
}
