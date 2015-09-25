/**
 * Cree una clase llamada Palabras que nos permitirá procesar palabras de la siguiente forma. Se dispondrá de 
 * un par de conjuntos (que serán dos atributos en la clase), el primero para palabras nuevas, y el segundo 
 * para palabras repetidas.

Cada vez que procesemos una palabra ésta se incorporará al conjunto de palabras nuevas, a no ser que ya se 
hubiese procesado previamente dicha palabra, en cuyo caso ésta se deberá de incluir en el conjunto de palabras 
repetidas y eliminar del conjunto de palabras nuevas.

Para procesar palabras la clase dispondrá de los siguientes métodos:

• incluirPalabra: Este método recibirá una palabra (String) y la procesará como se ha descrito anteriormente. 
El método devolverá verdadero si la palabra era nueva, o falso si la palabra ya estaba repetida.
• incluirFrase: Este método recibirá una frase, determinará las palabras que la forman, e irá procesando una 
a una las palabras de la misma haciendo uso del método anterior. El método devolverá verdadero en el caso de 
que todas las palabras de la frase fuesen nuevas o falso en el caso de que alguna de las palabras de la frase
estuviese repetidas.

Además de los métodos anteriores la clase dispondrán de los siguientes métodos:

• getPalabrasNuevas: Este método devolverá el conjunto de palabras que no han sido repetidas.
• getPalabrasRepetidas: Este método devolverá el conjunto de palabras que han sido repetidas.

La clase dispondrá de un constructor sin argumentos que tendrá como única tarea inicializar los atributos 
para representar los conjuntos de palabras nuevas y repetidas, de forma tal que éstos se inicialicen cada uno
 a un conjunto vacío. 
 */


package datos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Palabras listado = new Palabras();
		
		System.out.println("Insertar palabra (gurila): " + listado.incluirPalabra("gurila"));
		System.out.println("Insertar palabra (gurila) (2da vez): " + listado.incluirPalabra("gurila"));
		System.out.println("Insertar frase (el gorila se comió el alcornoque): " + listado.incluirFrase("el gorila se comió el alcornoque"));

		System.out.println("Listado de palabras nuevas: " + listado.getPalabrasNuevas().toString());
		System.out.println("Listado de palabras repetidas: " + listado.getPalabrasRepetidas().toString());
	}

}
