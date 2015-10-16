package es.altair.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.altair.bean.Usuario;

public class UsuarioDAO {

	public static int insertarUsuario(Usuario usu) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "INSERT INTO USUARIOS VALUES (null,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prepare = ConexionDAO.getConexion().prepareStatement(query);
			prepare.setString(1, usu.getNombre());
			prepare.setString(2, usu.getApellidos());
			prepare.setString(3, usu.getLogin());
			prepare.setString(4, usu.getPassword());
			prepare.setString(5, usu.getEmail());
			prepare.setInt(6, usu.getTipo_acceso());
			prepare.setInt(7, usu.getActivacion());
			num_filas = prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return num_filas;
	}

	public static ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> listado = new ArrayList<>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM USUARIOS";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Usuario u = new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombre"), resultado.getString("apellidos"),
						resultado.getString("login"), resultado.getString("password"), resultado.getString("email"),
						resultado.getInt("tipo_acceso"), resultado.getInt("activacion"));
				listado.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();
		return listado;
	}

}
