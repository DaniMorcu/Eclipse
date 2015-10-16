package es.altair.main;

import java.util.ArrayList;
import java.util.Scanner;

import es.altair.bean.Alumno;
import es.altair.dao.AlumnoDao;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		
		do {
			opcion = menu();
			switch (opcion) {
			case 1:	//	Listar Todos los Alumnos
				ArrayList<Alumno> alumnos = AlumnoDao.ListarAlumnos();
				for (Alumno alumno : alumnos) {
					System.out.println(alumno);
				}
				break;
			case 2:	//	Insertar nuevo alumno
				System.out.println("Nombre: ");
				String nombre = sc.next();
				System.out.println("Apellidos: ");
				String apellidos = sc.next();
				System.out.println("Edad: ");
				int edad = sc.nextInt();
				System.out.println("Matriculado (1:Si / 0:NO): ");
				int matriculado = sc.nextInt();
				
				Alumno alum = new Alumno(nombre, apellidos, edad, matriculado);
				
				if(AlumnoDao.insertarAlumno(alum) == 1)
					System.out.println("Alumno insertado");
				else
					System.out.println("Error al insertar alumno");
				break;
			case 3:	//	Actualizar alumno (Matricular o quitar)
				ArrayList<Alumno> alumnosCurso = AlumnoDao.ListarAlumnos();
				for (Alumno alumno : alumnosCurso) {
					System.out.println(alumno);
				}
				System.out.println("ID alumno: ");
				int idAlumnoCurso = sc.nextInt();
				
				if(AlumnoDao.actualizarMAtriculado(idAlumnoCurso) == 1)
					System.out.println("Alumno cambiado correctamente");
				else
					System.out.println("Error al cambiar alumno");
				
				break;
			case 4:	//	Borrar Alumno	
				ArrayList<Alumno> alumnosTodos = AlumnoDao.ListarAlumnos();
				for (Alumno alumno : alumnosTodos) {
					System.out.println(alumno);
				}
				
				System.out.println("ID alumno: ");
				int idalumno = sc.nextInt();
				
				if(AlumnoDao.borrarAlumno(idalumno) == 1){
					System.out.println("Alumno borrado correctamente");
				}
				else
					System.out.println("Error al borrar alumno");
				break;
			case 5:	//	Listar alumnos matriculados
				ArrayList<Alumno> alumnosMatriculados = AlumnoDao.ListarAlumnosMatriculados();
				for (Alumno alumno : alumnosMatriculados) {
					System.out.println(alumno);
				}
				break;
			default:
				break;
			}
		} while (opcion != 0);
		
		
	}

	public static int menu(){
		
		
		int opcion = 0;
		
		System.out.println("-- MENU -- ");
		System.out.println("1. Listar todos los alumnos");
		System.out.println("2. Insertar nuevo alumno");
		System.out.println("3. Actualizar matricula de alumno");
		System.out.println("4. Borrar alumno");
		System.out.println("5. Listar alumnos matriculados");
		System.out.println("0. Salir");
		
		opcion = sc.nextInt();
		
		return opcion;
	}
}
