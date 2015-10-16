package es.altair.main;

import java.util.ArrayList;
import java.util.Scanner;

import es.altair.bean.Receta;
import es.altair.bean.TipoReceta;
import es.altair.bean.Usuario;
import es.altair.DAO.RecetaDAO;
import es.altair.DAO.TipoRecetaDAO;
import es.altair.DAO.UsuarioDAO;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;
		do {
			opcion = menu();
			switch (opcion) {
			case 1:
				// Pido los datos del Usuario
				System.out.println("Nombre: ");
				String nombre = sc.next();
				System.out.println("Apellidos: ");
				String apellidos = sc.next();
				System.out.println("Login: ");
				String login = sc.next();
				System.out.println("Password: ");
				String password = sc.next();
				System.out.println("Email: ");
				String email = sc.next();
				System.out.println("Tipo Acceso: ");
				int tipo_acceso = sc.nextInt();
				System.out.println("Activacion: ");
				int activacion = sc.nextInt();

				// Crear un Usuario
				Usuario usu = new Usuario(nombre, apellidos, login, password, email, tipo_acceso, activacion);
				
				//Inserto al Usuario
				if (UsuarioDAO.insertarUsuario(usu) == 1)
					System.out.println("Usuario Insertado");
				else
					System.out.println("Error al Insertar Usuario");
				break;
			case 2:
				ArrayList<Usuario> listado = UsuarioDAO.listarUsuarios();
				for (Usuario usuario : listado) {
					System.out.println(usuario.getIdUsuario() + ". " + usuario.getNombre());
				}
				System.out.println("ID Usuario: ");
				int idUsuario = sc.nextInt();
				
				ArrayList<TipoReceta> listadotipos = TipoRecetaDAO.listarTipoRecetas();
				for (TipoReceta tipoReceta : listadotipos) {
					System.out.println(tipoReceta.getIdTipoReceta() + ". " + tipoReceta.getTiporeceta());
				}
				
				int idTipoReceta = sc.nextInt();
				System.out.println("Nueva receta: ");
				
				//	Pedimos los datos para la receta
				System.out.println("Nombre: ");
				String nombreRec = sc.next();
				System.out.println("Descripcion: ");
				String descripcion = sc.next();
				
				//	Crea la Receta
				Receta rec = new Receta(nombreRec, idTipoReceta, descripcion, idUsuario);
				
				//	Añadimos la receta
				if(RecetaDAO.insertarReceta(rec) == 1)
					System.out.println("Receta añadida");
				else
					System.out.println("Error al insertar la receta");				
				break;
			default:
				break;
			}
		} while (opcion != 0);

		sc.close();
	}

	private static int menu() {
		int opcion = 0;
		System.out.println("--- MENÚ ---");
		System.out.println("1.Insertar Usuario");
		System.out.println("2.Insertar Receta asociada a un usuario");
		System.out.println("3.Listar todos los usuarios agrupados por tipo de acceso y que estén activados");
		System.out.println("4.Actualizar el tipo de receta de una determinada receta");
		System.out.println("5.Borrar todas las recetas de un determinado usuario");
		System.out.println("6.Comprobar si un usuario está dado de alta en el sistema y mostrar su tipo de acceso");
		System.out.println(
				"7.Listar todas las recetas de tipo comida de los usuarios de tipo normal y que estén activados");
		System.out.println("8.Actualizar los datos de un usuario, incluido su tipo de acceso");
		System.out.println("9.Mostrar todo: cada uno de los usuarios con sus recetas");
		System.out.println("0. Salir");
		opcion = sc.nextInt();
		return opcion;
	}
}
