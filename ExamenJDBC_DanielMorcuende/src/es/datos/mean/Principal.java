package es.datos.mean;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import es.datos.bean.Categoria;
import es.datos.bean.Empresa;
import es.datos.bean.Producto;
import es.datos.dao.CategoriaDao;
import es.datos.dao.EmpresaDao;
import es.datos.dao.ProductoDAO;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcion = 0;	
		do{
		opcion = menu();	
		switch (opcion) {
		case 1:	// Inserte una nueva empresa			
			System.out.println("Nombre Empresa: ");
			String nombreEmpresa = sc.next();
			System.out.println("CIF: ");
			String cif = sc.next();
			System.out.println("Email: ");
			String email = sc.next();
			System.out.println("Ciudad: ");
			String ciudad = sc.next();
			System.out.println("Activado (0:No/1:Si): ");
			int activado = sc.nextInt();
			
			Empresa e = new Empresa(nombreEmpresa, cif, email, ciudad, activado);
			
			if(EmpresaDao.insertarEmpresa(e) == 1){
				System.out.println("Empresa añadida");
			}
			else
				System.out.println("Fallo al insertar la empresa");
			break;
		case 2:	//	Empresas activadas en una determinada ciudad
			System.out.println("Ciudad: ");
			String ciudadBuscar = sc.next();
			
			ArrayList<Empresa> listaEmpresasActivas = EmpresaDao.empresasActivasPorCiudad(ciudadBuscar);
			
			System.out.println("Lista de empresas activadas en " + ciudadBuscar + ":");
			for (Empresa empresa : listaEmpresasActivas) {
				System.out.println(empresa);
			}
			
			break;
		case 3:	// Actualizar empresa con su cif 
			ArrayList<Empresa> listaTodasEmpresas = EmpresaDao.listarEmpresas();
			
			for (Empresa empresa : listaTodasEmpresas) {
				System.out.println(empresa);
			}
			
			System.out.println("Elija un CIF: ");
			String cifElegir = sc.next();
			if(EmpresaDao.actualizarEstado(cifElegir) == 1){
				System.out.println("Actualizado el estado");
			} else {
				System.out.println("Fallo al actualizar");
			}
			break;
		case 4:	// Nuevo producto 
			System.out.println("Nombre Producto: ");
			String nombreProducto = sc.next();
			System.out.println("Precio: ");
			Double precio = sc.nextDouble();
			System.out.println("Descripcion: ");
			String descripcion = sc.next();
			System.out.println("Stock: ");
			int stock = sc.nextInt();
			
			//	Listamos todas las categorias
			ArrayList<Categoria> listaCategoria = CategoriaDao.listarCategorias();
			System.out.println("-- CATEGORIAS --");
			for (Categoria categoria : listaCategoria) {
				System.out.println(categoria);
			}
			System.out.println("Categoria (id): ");
			int idCategoria = sc.nextInt();
			
			//	Listamos todas las empresas 
			ArrayList<Empresa> listaEmpresas = EmpresaDao.listarEmpresas();
			System.out.println("-- EMPRESAS --");
			for (Empresa empresa : listaEmpresas) {
				System.out.println(empresa);
			}
			System.out.println("Empresa (id): ");
			int idEmpresa = sc.nextInt();
			
			Producto p = new Producto(nombreProducto, precio, descripcion, stock, idCategoria, idEmpresa);
			
			if(ProductoDAO.insertarProducto(p)==1){
				System.out.println("Producto añadido");
			} else {
				System.out.println("Error al insertar producto");
			}
			break;
		case 5: // Todos los productos de una determinada empresa
			ArrayList<Empresa> listaEmpresasPro = EmpresaDao.listarEmpresas();
			System.out.println("-- EMPRESAS --");
			for (Empresa empresa : listaEmpresasPro) {
				System.out.println(empresa);
			}
			System.out.println("Empresa (id): ");
			int idEmpresaPro = sc.nextInt();
			
			ArrayList<Producto> listaProductos = ProductoDAO.listaProductosEmpresa(idEmpresaPro);
			System.out.println("-- PRODUCTOS --");
			for (Producto producto : listaProductos) {
				System.out.println(producto);
			}
			break;
		case 6: // Incrementa stock de un producto de una determinada empresa
			ArrayList<Empresa> listaEmpresasPro2 = EmpresaDao.listarEmpresas();
			System.out.println("-- EMPRESAS --");
			for (Empresa empresa : listaEmpresasPro2) {
				System.out.println(empresa);
			}
			System.out.println("Empresa (id): ");
			int idEmpresaPro2 = sc.nextInt();
			System.out.println("-- PRODUCTOS --");
			ArrayList<Producto> listaProductos2 = ProductoDAO.listaProductosEmpresa(idEmpresaPro2);
			for (Producto producto : listaProductos2) {
				System.out.println(producto);
			}
			System.out.println("ID producto: ");
			int idProducto = sc.nextInt();
			
			
			System.out.println("Cantidad a aumentar: ");
			int cantidad = sc.nextInt();
			if(ProductoDAO.aumentarStock(idProducto, idEmpresaPro2, cantidad) == 1)
				System.out.println("Stock cambiado");
			else
				System.out.println("Fallo al aumentar el stock");
			
			

			break;
		case 7:	// El stock acumulado de todos los productos de una determinada empresa
			ArrayList<Empresa> listasEmpresas = EmpresaDao.listarEmpresas();
			System.out.println("-- EMPRESAS --");
			for (Empresa empresa : listasEmpresas) {
				System.out.println(empresa);
			}
			System.out.println("ID empresa: ");
			int idEmpresaTodoStock = sc.nextInt();
			
			if(ProductoDAO.sumarStock(idEmpresaTodoStock) == 1)
				System.out.println("Stock modificado");
			else
				System.out.println("Fallo al actualizar el stock");
			
			break;
		case 8:	// Borrar empresas y todos su productos (idEmpresa)
			ArrayList<Empresa> listasEmpresasBorrar = EmpresaDao.listarEmpresas();
			System.out.println("-- EMPRESAS --");
			for (Empresa empresa : listasEmpresasBorrar) {
				System.out.println(empresa);
			}
			System.out.println("ID empresa: ");
			int idEmpresaBorrar = sc.nextInt();
			
			EmpresaDao.borrarEmpresaYProductos(idEmpresaBorrar);
			break;

		case 9:	//	callablestatement
			System.out.println("ID producto: ");
			int idProductoBorrar = sc.nextInt();
			
			ProductoDAO.borrarProducto(idProductoBorrar);
			break;			
		case 10:	//	Muestra doos los productos de una determinada empresa (datos empresa y productos)
			
			break;
		default:
			break;
		}
			
		}while(opcion != 0);
		
	}

	public static int menu(){
		int num = 0;
		System.out.println("\n-- MENU --");
		System.out.println("1. Inserte una nueva empresa con los datos solicitados al usuario.");
		System.out.println("2. Muestre los datos de las empresas activadas de una determinada ciudad.");
		System.out.println("3. Actualice el estado de una empresa indicando su cif.");
		System.out.println("4. Inserte un nuevo producto con los datos solicitados al usuario.");
		System.out.println("5. Muestre todos los productos de una determinada empresa.");
		System.out.println("6. Incremente una determinada cantidad el stock de los productos de una determinada empresa.");
		System.out.println("7. Muestre el stock acumulado de todos los productos de una determinada empresa. ");
		System.out.println("8. Borre una determinada empresa con todos sus productos.");
		System.out.println("9. Realice una llamada a un callablestatement llamado “borrarProducto” pasando el id del producto a borrar.");
		System.out.println("10. Muestre todos los productos de una determinada empresa (datos de empresa y productos).");
		System.out.println("Opcion: ");
		num = sc.nextInt();
		
		return num;
		
	}
}
