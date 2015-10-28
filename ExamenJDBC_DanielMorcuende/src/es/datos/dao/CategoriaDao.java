package es.datos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.datos.bean.Categoria;

public class CategoriaDao {

	public static ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> lista = new ArrayList<>();
		
		String query = "SELECT * FROM categorias";
		
		ConexionDao.abrirConexion();
		
		try {
			Statement sentencia = ConexionDao.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			
			while (resultado.next()) {
				Categoria cat = new Categoria(resultado.getInt("idCategoria"), resultado.getString("nombreCategoria"));
				
				lista.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
		return lista;
	}

	
}
