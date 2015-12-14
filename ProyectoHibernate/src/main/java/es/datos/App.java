package es.datos;

import org.hibernate.Session;

public class App {

	public static void main(String[] args){
		HibernateUtil.buildSessionFactory();
		Session session = null;
		
		try {
			HibernateUtil.openSessionAndBindToThread();
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			session.beginTransaction();
			
			Usuarios usu1 = new Usuarios(1, "Usu1", "usseerr", "usu1@mail.com");
			
			session.save(usu1);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		
		HibernateUtil.closeSessionFactory();
		
	}
}
