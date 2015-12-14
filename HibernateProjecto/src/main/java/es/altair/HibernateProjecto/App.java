package es.altair.HibernateProjecto;

import org.hibernate.Session;

import es.altair.HibernateProjecto.HibernateUtil;
import es.altair.HibernateProjecto.Cancion;
import es.altair.HibernateProjecto.Genero;
import es.altair.HibernateProjecto.Lista;
import es.altair.HibernateProjecto.Usuario;

public class App 
{
	 public static void main( String[] args )
	    {
	    	HibernateUtil.buildSessionFactory();
			Session sesion = null;
			try {
				HibernateUtil.openSessionAndBindToThread();

				sesion = HibernateUtil.getSessionFactory().getCurrentSession();	
				
//				Usuario usu1 = new Usuario(01, "Pepe", "erpepe", "pepe@mail.com");
//				Usuario usu2 = new Usuario(02, "Yisus", "yiissuu", "yisus@mail.com");
//				Usuario usu3 = new Usuario(03, "Anacleta", "cleta", "anacleta@mail.com");

//				Genero gen1 = new Genero(01, "Rock");
//				Genero gen2 = new Genero(02, "Indie");
//				Genero gen3 = new Genero(03, "Pop");
//				Genero gen4 = new Genero(04, "Folk");
				
				Cancion c1 = new Cancion(01, "titulo01", "artista1", 01);
				Cancion c2 = new Cancion(02, "titulo02", "artista2", 02);
				Cancion c3 = new Cancion(03, "titulo03", "artista2", 03);
				Cancion c4 = new Cancion(04, "titulo04", "artista3", 03);
				
				Lista list1 = new Lista(01, "Lista Hoy", 01, "lista para escuchar hoy");
				Lista list2 = new Lista(02, "Lista Ayer", 02, "lista para escuchar ayer");
				Lista list3 = new Lista(03, "Lista Mañana", 03, "lista para escuchar mañana");
				
				c1.getListas().add(list1);
				c2.getListas().add(list2);
				c2.getListas().add(list3);
				c4.getListas().add(list1);
				c4.getListas().add(list2);
				c4.getListas().add(list3);
				
				list1.getCanciones().add(c1);
				list2.getCanciones().add(c2);
				list3.getCanciones().add(c2);
				list1.getCanciones().add(c4);
				list2.getCanciones().add(c4);
				list3.getCanciones().add(c4);
				
				
				sesion.beginTransaction();
				sesion.saveOrUpdate(c1);
				sesion.saveOrUpdate(c2);
				sesion.saveOrUpdate(c3);
				sesion.saveOrUpdate(c4);

				sesion.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				HibernateUtil.closeSessionAndUnbindFromThread();
			}

			HibernateUtil.closeSessionFactory();
	    }
}
