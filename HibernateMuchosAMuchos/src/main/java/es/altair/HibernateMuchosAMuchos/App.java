package es.altair.HibernateMuchosAMuchos;

import org.hibernate.Session;

import es.altair.HibernateMuchosAMuchos.HibernateUtil;
import es.altair.HibernateMuchosAMuchos.Profesor;

public class App 
{
    public static void main( String[] args )
    {
    	HibernateUtil.buildSessionFactory();
		Session sesion = null;
		try {
			HibernateUtil.openSessionAndBindToThread();

			sesion = HibernateUtil.getSessionFactory().getCurrentSession();

			Profesor profesor1= new Profesor(1, "Isabel", "Fuertes");
			Profesor profesor2= new Profesor(2, "Anabel", "Fuertes");
			Profesor profesor3= new Profesor(3, "Francisco", "Fuertes");
			
			Modulo modulo1=new Modulo(1, "Sistemas Operativos en Red");
			Modulo modulo2=new Modulo(2, "Entornos de desarrollo");
			Modulo modulo3=new Modulo(3, "Sistemas Informáticos");
			
			profesor1.getModulos().add(modulo1);
			profesor1.getModulos().add(modulo2);
			profesor2.getModulos().add(modulo3);
			
			modulo1.getProfesores().add(profesor1);
			modulo2.getProfesores().add(profesor1);
			modulo3.getProfesores().add(profesor2);
			
			sesion.beginTransaction();
			sesion.saveOrUpdate(profesor2);
			sesion.saveOrUpdate(profesor1);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
    }
}
