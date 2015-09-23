/*
Cree una clase llamada ModeloCoche para representar coches. La clase contendrá los métodos consultores 
y modificadores para los siguientes datos:

• Año de fabricación (anyo) de tipo entero.
• Velocidad máxima (velocidad) de tipo entero.
• Precio (precio) de tipo flotante.
• Nombre del modelo (nombre) de tipo String.
• Marca del modelo (marca) de tipo String.

Esta clase contendrá un método constructor con tantos argumentos como atributos que permitirá inicializar
 el valor de los mismos en el momento de creación.
Cree una clase llamada ModelosCoches para manipular una lista de coches (insertar, actualizar, 
borrar y listar). Su constructor por defecto creará una lista vacía.

Añada un método que guarde en un fichero un informe de los modelos de coches que figuran en la lista
en el que conste toda la información que se dispone de los mismos.

 */

package datos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ModelosCoches mc = new ModelosCoches();
		
		ModeloCoche m1 = new ModeloCoche(2015, 180, 180000, "n1", "m1");
		ModeloCoche m2 = new ModeloCoche(2014, 160, 180000, "n2", "m2");
		ModeloCoche m3 = new ModeloCoche(2012, 170, 180000, "n3", "m3");
		
		mc.
	}

}
