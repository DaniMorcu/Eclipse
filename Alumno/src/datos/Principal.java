/*
 Cree una clase Alumno para manipular alumnos. La clase contendrá los métodos consultores y modificadores para los
 siguientes datos: nombre (tipo String), apellidos (tipo String), edad (tipo entero), y nota del expediente (tipo flotante).

 Cree una clase Alumnos para manipular una lista de alumnos. La clase dispondrá de un método para añadir alumnos. 
 Su constructor por defecto creará una lista vacía.

 Añada a la clase anterior varios métodos, tantos como atributos tiene la clase Alumno, que nos permitan buscar a
 alumnos en función del valor de alguno de sus atributos. Estos métodos devolverán el primer alumno encontrado, o
  una referencia nula (null) si no se ha encontrado un alumno de esas características en la lista.

Estos métodos tendrán los siguientes prototipos:

• Alumno buscaPorNombre(String nombre).
• Alumno buscaPorApellidos(String apellidos).
• Alumno buscaPorEdad(int edad).
• Alumno buscaPorNota(float nota).

Añada un método de búsqueda con el prototipo IAlumno busca (String patron). Este método buscará un alumno 
cuyo nombre, apellidos, edad o nota sea igual al valor que se pasa como argumento.

 */

package datos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumnos listaAlumnos = new Alumnos();
		
		Alumno a1 = new Alumno("a1", "ap1", 15, 6.5F);	//	Usamos la F para que que distinga que es un Float
		Alumno a2 = new Alumno("a2", "ap2", 14, 8.8F);
		Alumno a3 = new Alumno("a3", "ap3", 17, 7.9F);
		
		listaAlumnos.anadir(a1);
		listaAlumnos.anadir(a2);
		listaAlumnos.anadir(a3);

		System.out.println("Buscar por nombre: " + listaAlumnos.buscaPorNombre("a1"));
		System.out.println("Buscar por Apellidos: " + listaAlumnos.buscaPorApellidos("ap2"));
		System.out.println("Buscar por Edad: " + listaAlumnos.buscaPorEdad(14));
		System.out.println("Buscar por Nota: " + listaAlumnos.buscaPorNota(7.9F));
		
		System.out.println("Buscar por Patron: " + listaAlumnos.buscarPatron("14"));
		
	}

}
