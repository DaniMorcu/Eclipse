package es.altair.mongodb02;

import java.util.Scanner;

public class App {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		GestoBD.conexionBD();
		GestoBD.crearColeccion();

		int opcion = 0;
		do {
			opcion = menu();
			switch (opcion) {
			case 1:
				System.out.println("Titulo: ");
				String titulo = sc.next();
				System.out.println("Numero de páginas: ");
				int numPag = sc.nextInt();
				System.out.println("Editorial: ");
				String editorial = sc.next();
				System.out.println("Año de publicacion: ");
				int anyoPubli = sc.nextInt();
				System.out.println("Web: ");
				String web = sc.next();
				System.out.println("Precio: ");
				double precio = sc.nextDouble();

				Libro libro = new Libro(titulo, numPag, editorial, anyoPubli, web, precio);

				GestoBD.anyadirLibro(libro);

				break;
			case 2:
				int opcion2 = menu2();
				switch (opcion) {
				case 1:
					GestoBD.buscarPagsAnyo();
					break;
				case 2:
					GestoBD.todosAnaya();
					break;
				case 3:
					GestoBD.contarMayor20();
					break;
				case 4:

					break;
				default:
					break;
				}
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;

			default:
				break;
			}

		} while (opcion != 0);

		GestoBD.cerrarConexion();

	}

	public static int menu() {
		int opcion = 0;

		System.out.println("1. Añadir libro");
		System.out.println("2. Buscar libro");
		System.out.println("3. Libros ordenados por precio");
		System.out.println("4. Incrementar precio");
		System.out.println("5. Borrar libro");
		;
		System.out.println("0. Salir");

		return opcion = sc.nextInt();
	}

	public static int menu2() {
		int opcion = 0;

		System.out.println("1. Primer libro con numero de páginas > 200 y año de publicacion = 2014");
		System.out.println("2. Todos los libros de Anaya");
		System.out.println("3. Contar todos los libros precio > 20");
		System.out.println("4. Mostrar libros con web");
		System.out.println("0. Salir");

		return opcion = sc.nextInt();
	}
}
