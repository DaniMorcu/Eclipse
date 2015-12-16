package es.altair;

import java.util.ArrayList;

import javax.management.Query;

import org.hibernate.Session;

public class CajeraDAO {

	public static ArrayList<Cajera> listarCajeras(Session sesion) {
		return (ArrayList<Cajera>) sesion.createQuery("SELECT caj FROM Cajera caj").list();
	}

	public static void anyadirCajera(Session sesion, Cajera caj) {
		sesion.saveOrUpdate(caj);
//		sesion.beginTransaction();
//		sesion.getTransaction().commit();
	}

}
