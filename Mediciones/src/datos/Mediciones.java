package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mediciones {

	public static void importarMedicionesMinima(String ficheroEnt, String ficheroSal)
	{
		File ficheroEntrada = new File(ficheroEnt);
		File ficheroSalida = new File(ficheroSal);
		
		String linea = "";
		
		int min = 0;
		
		if(ficheroEntrada.exists())
		{
			FileReader fr = null;
			BufferedReader br = null;
			
			if(!ficheroSalida.exists())
			{
				try {
					ficheroSalida.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try
			{
				fr = new FileReader(ficheroEntrada);
				br = new BufferedReader(fr);
				
				fw = new FileWriter(ficheroSalida);
				bw = new BufferedWriter(fw);

				while((linea = br.readLine()) != null)
				{
					String [] partes = linea.split(" ");
					
					min = Integer.parseInt(partes[1]);
					
					for (int i = 1; i < partes.length; i++) {
						if(min >= Integer.parseInt(partes[i]))
							min = Integer.parseInt(partes[i]);
					}
					
					//	Para escribir en el nuevo fichero
					bw.write(partes[0] + " " + min);
					bw.newLine();
					bw.flush();
				}
				
			
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					fr.close();
					br.close();
					
					fw.close();
					bw.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
		}
		 
	}
}
