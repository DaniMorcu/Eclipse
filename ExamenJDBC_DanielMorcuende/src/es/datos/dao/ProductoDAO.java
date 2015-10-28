package es.datos.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;

import es.datos.bean.Producto;

public class ProductoDAO {

	public static int insertarProducto(Producto p) {
		int numFilas = 0;

		String query = "INSERT INTO productos VALUES (null, ?, ?, ?, ?, ?, ?)";

		ConexionDao.abrirConexion();

		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setString(1, p.getNombreProducto());
			prepare.setDouble(2, p.getPrecio());
			prepare.setString(3, p.getDescripcion());
			prepare.setInt(4, p.getStock());
			prepare.setInt(5, p.getIdCategoria());
			prepare.setInt(6, p.getIdEmpresa());
			numFilas = prepare.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}

		return numFilas;
	}

	public static ArrayList<Producto> listaProductosEmpresa(int idEmpresaPro) {
		ArrayList<Producto> lista = new ArrayList<>();

		String query = "SELECT * FROM productos WHERE idEmpresa = ?";

		ConexionDao.abrirConexion();

		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setInt(1, idEmpresaPro);

			ResultSet resultado = prepare.executeQuery();

			while (resultado.next()) {
				Producto p = new Producto(resultado.getString("nombreProducto"), resultado.getDouble("precio"),
						resultado.getString("descripcion"), resultado.getInt("stock"), resultado.getInt("idCategoria"),
						resultado.getInt("idEmpresa"));
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}

		return lista;
	}

	public static int aumentarStock(int idProducto, int idEmpresaPro2, int cantidad) {

		int numFilas = 0;
		
		String query = "UPDATE productos SET stock = ? WHERE idProductos = ? AND idEmpresa = ?";
		
		ConexionDao.abrirConexion();
		
		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setInt(1, cantidad);
			prepare.setInt(2, idProducto);
			prepare.setInt(3, idEmpresaPro2);
			
			numFilas = prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
		return numFilas;
	}

	public static int sumarStock(int idEmpresaTodoStock) {
		int total = 0;
		
		String query = "SELECT productos COUNT(stock) WHERE idEmpresas = ?";
		
		ConexionDao.abrirConexion();
		
		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setInt(1, idEmpresaTodoStock);
	
			prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
		return total;
	}
	
	public static void borrarProducto(int idProductoBorrar) {
		ConexionDao.abrirConexion();
		
		try {
			CallableStatement call = ConexionDao.getConexion().prepareCall("{call borrarProducto(?)}");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
