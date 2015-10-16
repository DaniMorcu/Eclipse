package es.altair.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.altair.bean.Receta;

public class RecetaDAO {

	public static int insertarReceta(Receta receta ){
		
		int num_filas = 0;
		
		ConexionDAO.abrirConexion();
		
		String query = "INSERT INTO recetas VALUES (null, ?, ?, ?, ?)";
		
		try {
			PreparedStatement prepare = ConexionDAO.getConexion().prepareStatement(query);
			
			prepare.setString(1, receta.getNombre());
			prepare.setInt(2, receta.getIdReceta());
			prepare.setString(3, receta.getDescripcion());
			prepare.setInt(4, receta.getIdUsuario());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexionDAO.cerrarConexion();
		
		return num_filas;
	}
}
