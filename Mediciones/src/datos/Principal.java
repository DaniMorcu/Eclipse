/*
 
En una f�brica de alimentos se han instalado sensores para monitorear la temperatura de distintos lugares de la 
f�brica en ciertos momentos de tiempo. La informaci�n tomada por estos sensores es almacenada en un archivo mediciones.txt
que tiene el siguiente formato:

s2 9 10 11 9 9
s23 8 8 7 10 6
s211 9
s12 8 7 6 9 9
s14 10 10

Las l�neas almacenan las temperaturas registradas por cada sensor. Cada una de estas l�neas tiene el identificador 
del sensor seguido por una lista de temperaturas. Por ejemplo, para el sensor con identificador s12 se registraron 
las temperaturas 8, 7, 6, 9 y 9.

En este ejercicio usted debe crear las funciones necesarias para leer la informaci�n contenida en el 
archivo mediciones.txt, extraer para cada sensor la temperatura m�nima que registr� y almacenar esta informaci�n 
en el archivo medicionesmin.txt, que tiene el siguiente formato:

s23 6
s12 6
s2 9
s211 9
s14 10

 */

package datos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mediciones.importarMedicionesMinima("mediciones.txt", "medicionesmin.txt");
		System.out.println("�Fichero con las temperaturas minimas realizado!");
	}

}
