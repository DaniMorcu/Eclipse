package es.altair;

import java.util.ArrayList;

import javax.management.Query;

import org.hibernate.Session;

public class ClienteDAO {

	public static ArrayList<Cliente> listarClientes(Session sesion) {
		return (ArrayList<Cliente>) sesion.createQuery("SELECT c FROM Cliente c").list();
	}

	public static void borrarCliente(Session sesion, int idCliente) {	
		try {
			Cliente c = (Cliente) sesion.createQuery("SELECT c FROM Cliente c WHERE idCliente = " + idCliente).uniqueResult();
			sesion.delete(c);

		} catch (Exception e) {
			System.out.println("No se ha borrado ningún registro");
		}

	}
	
	

}
