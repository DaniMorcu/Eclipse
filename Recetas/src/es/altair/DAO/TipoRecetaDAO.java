package es.altair.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.altair.bean.TipoReceta;

public class TipoRecetaDAO {

	public static ArrayList<TipoReceta> listarTipoRecetas() {
		ArrayList<TipoReceta> listadotipos = new ArrayList<>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM TIPORECETAS";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				TipoReceta tr = new TipoReceta(resultado.getInt("idTipoReceta"), resultado.getString("tiporeceta"));
				listadotipos.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();
		return listadotipos;
	}

}

