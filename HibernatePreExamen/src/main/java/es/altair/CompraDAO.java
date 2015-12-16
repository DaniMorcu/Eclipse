package es.altair;

import java.util.ArrayList;

import org.hibernate.Session;

public class CompraDAO {

	public static ArrayList<Compra> listarCompras(Session sesion) {
		return (ArrayList<Compra>) sesion.createQuery("SELECT com FROM Compra com").list();
	}

}
