package es.datos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.datos.bean.Empresa;

public class EmpresaDao {

	public static int insertarEmpresa(Empresa e) {
		int numFilas = 0;

		String query = "INSERT INTO empresas VALUES (null, ?, ?, ?, ?, ?)";

		ConexionDao.abrirConexion();

		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setString(1, e.getNombreEmpresa());
			prepare.setString(2, e.getCif());
			prepare.setString(3, e.getEmail());
			prepare.setString(4, e.getCiudad());
			prepare.setInt(5, e.getActivado());
			numFilas = prepare.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}

		return numFilas;

	}

	public static ArrayList<Empresa> empresasActivasPorCiudad(String ciudadBuscar) {
		ArrayList<Empresa> lista = new ArrayList<>();

		String query = "SELECT * FROM empresas WHERE activado = 1 AND ciudad = ?";

		ConexionDao.abrirConexion();

		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setString(1, ciudadBuscar);
			ResultSet resultado = prepare.executeQuery();

			while (resultado.next()) {
				Empresa e = new Empresa(resultado.getInt("idEmpresa"), resultado.getString("nombreEmpresa"),
						resultado.getString("cif"), resultado.getString("email"), resultado.getString("ciudad"),
						resultado.getInt("activado"));

				lista.add(e);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}

		return lista;

	}

	public static ArrayList<Empresa> listarEmpresas() {
		ArrayList<Empresa> lista = new ArrayList<>();

		String query = "SELECT * FROM empresas";

		ConexionDao.abrirConexion();

		try {
			Statement sentencia = ConexionDao.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);

			while (resultado.next()) {
				Empresa e = new Empresa(resultado.getInt("idEmpresa"), resultado.getString("nombreEmpresa"),
						resultado.getString("cif"), resultado.getString("email"), resultado.getString("ciudad"),
						resultado.getInt("activado"));

				lista.add(e);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}

		return lista;

	}

	public static int actualizarEstado(String cif) {
		int numFilas = 0;
		
		String query = "UPDATE empresas SET activado = !activado WHERE cif = ?";
		
		ConexionDao.abrirConexion();
		
		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setString(1, cif);
			
			numFilas =  prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
		return numFilas;
	}

	public static void borrarEmpresaYProductos(int idEmpresaBorrar) {
		
		String query = "";
		
		ConexionDao.abrirConexion();
		
		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setInt(1, idEmpresaBorrar);
			
			prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
	}
	
	
}
