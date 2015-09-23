/*
 * Un supermercado ha puesto en funcionamiento la posibilidad de realizar los pedidos de forma telefónica. 
 * Usted debe completar la implementación de la clase Producto que posee un precio, un código y un nombre. 
 * Debe añadir, borrar, actualizar y listar todos los productos. Además, debe generar un fichero con los datos 
 * de los productos y mostrar la posibilidad de generar el mapa de productos a partir de un fichero externo.
 * 
 */

package datos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Supermercado.anadir((new Producto(1,  "patatas", 20)));
		Supermercado.anadir((new Producto(2,  "manzanas", 30)));
		Supermercado.anadir((new Producto(3,  "platanos", 40)));
		Supermercado.anadir((new Producto(4,  "melon", 50)));
		Supermercado.anadir((new Producto(5,  "sandias", 60)));
		Supermercado.anadir((new Producto(6,  "kiwis", 80)));
		
		Supermercado.listar();

		Supermercado.actualizar(new Producto(4, "MELON", 2));
		
		Supermercado.listar();
		
		if(Supermercado.borrar(15)){
			System.out.println("Producto borrado");
		}
		else
			System.out.println("Producto NO borrado");
		
		
		Supermercado.generarFichero("ficheroProductos.txt");
		
		Supermercado.borrarProductos();
		
		Supermercado.listar();
		
		Supermercado.importarFichero("ficheroProductos.txt");
		
		Supermercado.listar();
	}

}
