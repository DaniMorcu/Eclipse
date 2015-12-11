package es.altair;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;

public class AppPrincipal {

	private static Scanner sc = new Scanner(System.in);
	
	public static void metodo() {
			HibernateUtil.buildSessionFactory();
			Session sesion = null;
			try {
				HibernateUtil.openSessionAndBindToThread();

				sesion = HibernateUtil.getSessionFactory().getCurrentSession();
				
				int opcion = 0;
				do {
					opcion = menu();
					switch (opcion) {
					case 1:	
						ArrayList<Cliente> listadoClientes = new ArrayList<Cliente>();
						listadoClientes = ClienteDAO.listarClientes(sesion);
						break;

					default:
						break;
					}
				} while (opcion!=0);
				
				

				sesion.beginTransaction();

				sesion.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				HibernateUtil.closeSessionAndUnbindFromThread();
			}
			HibernateUtil.closeSessionFactory();
	}
	
	private static int menu(){
		int opcion = 0;
		System.out.println("-- MENU --");
		System.out.println("1. Listar Clientes");
		System.out.println("2. Borrar Clientes");
		System.out.println("3. Ver compra");
		System.out.println("4. Listar Cajera");
		System.out.println("5. Añadir Cajera");
		System.out.println("6. Borrar Cajera");
		System.out.println("7. Listar Productos");
		System.out.println("8. Añadir Producto");
		System.out.println("9. Borrar Producto");
		System.out.println("10. Comprar Producto");
		System.err.println("11. Hitorial de Compras");
		System.out.println("0. Salir");
		
		opcion = sc.nextInt();
		return opcion;
	}
		



}


