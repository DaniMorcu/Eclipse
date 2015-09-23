package datos;

import java.util.ArrayList;

public class ModelosCoches {

	private ArrayList<ModeloCoche> coches = new ArrayList<>();
	
	public void insertar(ModeloCoche m)
	{
		coches.add(m);
	}
	
	public void borrar(String modelo)
	{
		if(coches.contains(coches))
		{
			coches.remove(modelo);
		}
		else
			System.out.println("No se encontró el vehículo.");
	}
	
	public void actualizar(String modelo)
	{
		if(coches.contains(modelo))
		{
			System.out.println("Nuevo año: ");
			ModeloCoche
			
		}
	}
}
