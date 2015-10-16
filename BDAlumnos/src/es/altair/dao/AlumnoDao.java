package es.altair.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import es.altair.bean.Alumno;

public class AlumnoDao {

	public static int insertarAlumno(Alumno alum) {

		int numFilas = 0;
		ConexionDao.abrirConexion();
		
		String query = "INSERT INTO alumno VALUES (null, ?, ?, ?, ?)";	
		
		try {
			
			//	Si vamos a usar condiciones usamos el PreparedStatement porque luego le ejecutamos una inyeccion a las 
			//	interrogantes
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setString(1, alum.getNombre());
			prepare.setString(2, alum.getApellidos());
			prepare.setInt(3, alum.getEdad());
			prepare.setInt(4, alum.getMatriculado());
			
			numFilas = prepare.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
				
		return numFilas;
	}

	public static ArrayList<Alumno> ListarAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		
		ConexionDao.abrirConexion();
		
		String query = "SELECT * FROM alumno";
		//	El Statement no tiene condicones (where) por ejemplo en los select
		try {
			java.sql.Statement sentencia = ConexionDao.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			
			while(resultado.next()){
				Alumno a = new Alumno(resultado.getInt("idAlumno"), resultado.getString("nombre"), resultado.getString("apellidos"), resultado.getInt("edad"), resultado.getInt("matriculado"));
				alumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
		return alumnos;
	}

	public static int borrarAlumno(int idalumno) {
		int numFilas = 0;
		
		ConexionDao.abrirConexion();
		
		String query = "DELETE FROM alumno WHERE idalumno = ?";
		
		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setInt(1, idalumno);
			numFilas = prepare.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
		
		return numFilas;
	}

	public static ArrayList<Alumno> ListarAlumnosMatriculados() {
	ArrayList<Alumno> alumnos = new ArrayList<>();
		
		ConexionDao.abrirConexion();
		
		String query = "SELECT * FROM alumno WHERE matriculado = 1";
		//	El Statement no tiene condicones (where) por ejemplo en los select
		try {
			java.sql.Statement sentencia = ConexionDao.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			
			while(resultado.next()){
				Alumno a = new Alumno(resultado.getInt("idAlumno"), resultado.getString("nombre"), resultado.getString("apellidos"), resultado.getInt("edad"), resultado.getInt("matriculado"));
				alumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
		return alumnos;
	}



	public static int actualizarMAtriculado(int idAlumnoCurso) {
		int numFilas = 0;
		
		ConexionDao.abrirConexion();
		
		String query = "UPDATE alumno SET matriculado = !matriculado WHERE idalumno = ?";
		
		try {
			PreparedStatement prepare = ConexionDao.getConexion().prepareStatement(query);
			prepare.setInt(1, idAlumnoCurso);
			numFilas = prepare.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDao.cerrarConexion();
		}
		
		return numFilas;
	}
	
}
