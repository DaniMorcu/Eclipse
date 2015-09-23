/*
 Cree una clase Alumno para manipular alumnos. La clase contendr� los m�todos consultores y modificadores para los
 siguientes datos: nombre (tipo String), apellidos (tipo String), edad (tipo entero), y nota del expediente (tipo flotante).

 Cree una clase Alumnos para manipular una lista de alumnos. La clase dispondr� de un m�todo para a�adir alumnos. 
 Su constructor por defecto crear� una lista vac�a.

 A�ada a la clase anterior varios m�todos, tantos como atributos tiene la clase Alumno, que nos permitan buscar a
 alumnos en funci�n del valor de alguno de sus atributos. Estos m�todos devolver�n el primer alumno encontrado, o
  una referencia nula (null) si no se ha encontrado un alumno de esas caracter�sticas en la lista.

Estos m�todos tendr�n los siguientes prototipos:

� Alumno buscaPorNombre(String nombre).
� Alumno buscaPorApellidos(String apellidos).
� Alumno buscaPorEdad(int edad).
� Alumno buscaPorNota(float nota).

A�ada un m�todo de b�squeda con el prototipo IAlumno busca (String patron). Este m�todo buscar� un alumno 
cuyo nombre, apellidos, edad o nota sea igual al valor que se pasa como argumento.

 */

package datos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumnos listaAlumnos = new Alumnos();
		
		Alumno a1 = new Alumno("a1", "ap1", 15, 6);
		Alumno a2 = new Alumno("a2", "ap2", 14, 8);
		Alumno a3 = new Alumno("a3", "ap3", 17, 7);
		
		listaAlumnos.anadirAlumno(a1);
		listaAlumnos.anadirAlumno(a2);
		listaAlumnos.anadirAlumno(a3);

		listaAlumnos.buscaPorNombre("a1");
		
	}

}
