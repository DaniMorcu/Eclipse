package datos;

import java.util.ArrayList;

public class ModelosCoches {

	private ArrayList<ModeloCoche> coches = new ArrayList<>();
	
	public ModelosCoches()
	{
		coches = new ArrayList<>();
	}

	public void insertar(ModeloCoche mc)
	{
		coches.add(mc);
	}
	
	public boolean actualizar(ModeloCoche mcOld, ModeloCoche mcNew)
	{
		boolean resultado = false;
		if(coches.contains(mcOld))
		{
			coches.set(coches.indexOf(mcOld), mcNew);
			resultado = true;			
		}
		
		return resultado;
	}
	
	public boolean borrar(ModeloCoche mc)
	{
		return coches.remove(mc);
	}
	
	public void listar()
	{
		int cuantos = 0;
		System.out.println("Listado: ");
		for (ModeloCoche modeloCoches: coches) {
			
		}
	}
	

}
