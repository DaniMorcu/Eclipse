package datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModelosCoches {

	private ArrayList<ModeloCoche> coches;
	
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
	
	public void listar() {
		int cuantos = 0;
		System.out.println("--- LISTADO ---");
		for (ModeloCoche modeloCoche : coches) {
			System.out.println(modeloCoche);
			cuantos++;
		}
		System.out.println("Nº de Coches: " + cuantos);
		System.out.println("---------------");
	}
	
	public void generarFichero(String nombFich) {
		File fichero = new File(nombFich);

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);

			for (ModeloCoche modeloCoche : coches) {
				bw.write(modeloCoche.getAnyo() + " " + modeloCoche.getMarca() + " " + modeloCoche.getNombre() + " "
						+ modeloCoche.getPrecio() + " " + modeloCoche.getVelocidad());
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
