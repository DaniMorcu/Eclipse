package es.altair;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;

public class AppUtil {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		Session sesion = null;
		try {
			HibernateUtil.openSessionAndBindToThread();

			sesion = HibernateUtil.getSessionFactory().getCurrentSession();
			
			
			int opcion = 0;
			do {
				opcion = menu();
				switch (opcion) {
				case 1: // Listar Clientes
					ArrayList<Cliente> listadoClientes = new ArrayList<Cliente>();
					listadoClientes = ClienteDAO.listarClientes(sesion);
					for (Cliente cliente : listadoClientes) {
						System.out.println(cliente);
					}
					break;
				case 2: // Borrar Cliente
					ArrayList<Cliente> listadoClientes2 = new ArrayList<Cliente>();
					listadoClientes2 = ClienteDAO.listarClientes(sesion);
					for (Cliente cliente : listadoClientes2) {
						System.out.println(cliente);
					}
					System.out.println("Seleccione a un cliente (idCliente): ");
					int idCliente = sc.nextInt();
					ClienteDAO.borrarCliente(sesion, idCliente);
				case 3:	// Ver compras
					ArrayList<Compra> listaCompras = new ArrayList<Compra>();
					listaCompras = CompraDAO.listarCompras(sesion);
					break;
				case 4:	// Listar cajeras
					ArrayList<Cajera> listadoCajeras = new ArrayList<Cajera>();
					listadoCajeras = CajeraDAO.listarCajeras(sesion);
					for (Cajera cajera : listadoCajeras) {
						System.out.println(cajera);
					}
					break;
				case 5:	// Añadir Cajera
					System.out.println("Nombre: ");
					String nombre = sc.next();
					System.out.println("Numero de Caja: ");
					int numCaja = sc.nextInt();
					
					Cajera caj = new Cajera(nombre, numCaja);
					CajeraDAO.anyadirCajera(sesion, caj);ç
				case 6: // Borrar Cajera
					
					break;
				default:
					break;
				}
				
				sesion.beginTransaction();
				sesion.getTransaction().commit();
			} while (opcion!=0);
			

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
		
		sc.close();
	}
	
	private static int menu() {
		int opcion = 0;
		System.out.println("-- MENÚ --");
		System.out.println("1. Listar Clientes");
		System.out.println("2. Borrar Cliente");
		System.out.println("3. Ver Compras");
		System.out.println("4. Listar Cajeras");
		System.out.println("5. Añadir Cajera");
		System.out.println("6. Borrar Cajera");
		System.out.println("7. Listar Productos");
		System.out.println("8. Añadir Producto");
		System.out.println("9. Borrar Producto");
		System.out.println("10. Comprar Producto");
		System.out.println("11. Historial de Compra");
		System.out.println("12. Cambiar Contraseña");
		System.out.println("0. Salir");
		opcion = sc.nextInt();
		return opcion;
	}

}
