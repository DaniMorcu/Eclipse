/**
 * Cree una clase llamada Palabras que nos permitir� procesar palabras de la siguiente forma. Se dispondr� de 
 * un par de conjuntos (que ser�n dos atributos en la clase), el primero para palabras nuevas, y el segundo 
 * para palabras repetidas.

Cada vez que procesemos una palabra �sta se incorporar� al conjunto de palabras nuevas, a no ser que ya se 
hubiese procesado previamente dicha palabra, en cuyo caso �sta se deber� de incluir en el conjunto de palabras 
repetidas y eliminar del conjunto de palabras nuevas.

Para procesar palabras la clase dispondr� de los siguientes m�todos:

� incluirPalabra: Este m�todo recibir� una palabra (String) y la procesar� como se ha descrito anteriormente. 
El m�todo devolver� verdadero si la palabra era nueva, o falso si la palabra ya estaba repetida.
� incluirFrase: Este m�todo recibir� una frase, determinar� las palabras que la forman, e ir� procesando una 
a una las palabras de la misma haciendo uso del m�todo anterior. El m�todo devolver� verdadero en el caso de 
que todas las palabras de la frase fuesen nuevas o falso en el caso de que alguna de las palabras de la frase
estuviese repetidas.

Adem�s de los m�todos anteriores la clase dispondr�n de los siguientes m�todos:

� getPalabrasNuevas: Este m�todo devolver� el conjunto de palabras que no han sido repetidas.
� getPalabrasRepetidas: Este m�todo devolver� el conjunto de palabras que han sido repetidas.

La clase dispondr� de un constructor sin argumentos que tendr� como �nica tarea inicializar los atributos 
para representar los conjuntos de palabras nuevas y repetidas, de forma tal que �stos se inicialicen cada uno
 a un conjunto vac�o. 
 */


package datos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Palabras listado = new Palabras();
		
		System.out.println("Insertar palabra (gurila): " + listado.incluirPalabra("gurila"));
		System.out.println("Insertar palabra (gurila) (2da vez): " + listado.incluirPalabra("gurila"));
		System.out.println("Insertar frase (el gorila se comi� el alcornoque): " + listado.incluirFrase("el gorila se comi� el alcornoque"));

		System.out.println("Listado de palabras nuevas: " + listado.getPalabrasNuevas().toString());
		System.out.println("Listado de palabras repetidas: " + listado.getPalabrasRepetidas().toString());
	}

}
