package es.altair;

import java.util.ArrayList;

import javax.management.Query;

import org.hibernate.Session;

public class ClienteDAO {

	public static ArrayList<Cliente> listarClientes(Session sesion) {
		return (ArrayList<Cliente>) sesion.createQuery("SELECT c FROM Cliente c").list();	// esto es HQL
		
	}

}
