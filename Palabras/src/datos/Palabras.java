package datos;

import java.util.HashSet;

public class Palabras {

	private HashSet<String> palabrasNuevas;
	private HashSet<String> palabrasRepetidas;
	
	
	
	public Palabras() {
		palabrasNuevas = new HashSet<>();
		palabrasRepetidas = new HashSet<>();
	}

	public boolean incluirPalabra(String palabra)
	{
		if(!palabrasNuevas.contains(palabra))
		{
			palabrasNuevas.add(palabra);
			return true;
		}
		else
		{
			palabrasRepetidas.add(palabra);
			return false;
		}
	}
	
	public boolean incluirFrase(String frase)
	{
		boolean todasNuevas = true;
		String [] palabrasSueltas = frase.split(" ");
		
		for (int i= 0; i<palabrasSueltas.length; i++) {
			if(!incluirPalabra(palabrasSueltas[i]))
				todasNuevas = false;
		}
		return todasNuevas; 
	}

	public HashSet<String> getPalabrasNuevas() {
		return palabrasNuevas;
	}

	public HashSet<String> getPalabrasRepetidas() {
		return palabrasRepetidas;
	}

	@Override
	public String toString() {
		return "Palabras [palabrasNuevas=" + palabrasNuevas + ", palabrasRepetidas=" + palabrasRepetidas + "]";
	}
	
	
	
	
}
