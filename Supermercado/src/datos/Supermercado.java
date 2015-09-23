package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Supermercado {

	private static HashMap<Integer, Producto> pedidos = new HashMap<>();

	public static void anadir(Producto p) {
		pedidos.put(p.getCodigo(), p);
	}

	public static boolean borrar(int codigo) {
		if (pedidos.remove(codigo) == null)
			return false;
		else
			return true;
	}

	public static void actualizar(Producto p) {
		if (pedidos.containsKey(p.getCodigo())) {
			pedidos.replace(p.getCodigo(), p);
		}

	}

	public static void listar() {
		
		System.out.println("---- LISTADO ----");
		for (Producto p : pedidos.values()) {
			System.out.println(p);
		}
		
		System.out.println("-----------------");
	}

	public static void borrarProductos(){
		pedidos.clear();
	}
	
	public static void generarFichero(String nombFich) {
		File fichero = new File(nombFich);

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(nombFich);
			bw = new BufferedWriter(fw);

			for (Producto p : pedidos.values()) {
				bw.write(p.getCodigo() + ";" + p.getNombre() + ";" + p.getPrecio());
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public static void importarFichero(String nombFich) {
		File fichero = new File(nombFich);

		if (fichero.exists()) {
			// pedidos.clear();

			FileReader fr = null;
			BufferedReader br = null;

			try {
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);

				String linea;

				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split(";");

					Producto p = new Producto(Integer.parseInt(partes[0]), partes[1], Double.parseDouble(partes[2]));
					
					anadir(p);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

	}
}
