package es.altair.ProjectoMongodbDriver;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App 
{
	private static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	GestorBD.conexionBD();
    	GestorBD.crearColeccionReserva();
    	
//    	//	Cargamos unas reservas y jugadores para poder trabajar con Mongo
//    	cargaReservas();
    	
    	int opcion = 0;
    	do{
    		opcion = menu();
    		switch (opcion) {
			case 1:	//	Nueva RESERVA	
				//	Directamente llamamos al metodo donde solicitará rellenar los distintos campos y devolverá el objeto Reserva
		    	GestorBD.anyadirReserva(solicitarDatosReserva());
				break;
			case 2:	//	Nuevo RESERVA y JUGADOR
				//	Al igual que en el caso 1, pedimos los campos de Reserva y Jugador
				GestorBD.anyadirReservaYJugador(solicitarDatosReserva(), solicitarDatosJugador());				
				break;
			case 3:	//	PRIMERA RESERVA de una determinada FECHA y NO ESTA PAGADA
				Date fechaBuscar = pedirFecha();
				GestorBD.encontrarReservaYNoPagada(fechaBuscar);				
				break;
			case 4:	//	Listar RESERVAS PAGADAS y SEVILLA
				GestorBD.listarReservasPagadasSevilla();
				break;
			case 5:	//	Listar RESERVAS ANTERIORES y NO PAGADAS
				GestorBD.listarReservasAnterioresHoyNoPagadas();
			case 6:	//	CONTAR SOCIOS y CIUDAD
				System.out.print("Escriba la ciudad: ");
				String ciudad = sc.next();
				GestorBD.contarSociosCiudad(ciudad);
				break;
			case 7:	//	Listar PRECIOS ORDENADOS CRECIENTE
				GestorBD.listarPreciosOrdenadosCrec();
				break;
			case 8: //	SUMAR todas las RESERVAS y NO PAGADAS
				GestorBD.sumarReservasNoPagadas();
				break;
			case 9:	//	Actualizar RESERVAS y HUELVA y AÑO INSCRIPCION < 2008 para PRECIO 50% DESCUENTO
				GestorBD.actualizarHuelvaAnyo2008();
				break;
			case 10: 	//	BORRAR RESERVAS PAGADAS y ANTERIORES A ESTE AÑO
				GestorBD.borrarPagadasAnteioresAnyo();
				break;
			default:
				System.out.println("Opción incorrecta. Entradas válidas del 0 al 10\n\n");
				break;
			}
    	}while(opcion != 0);	
    	
    	GestorBD.cerrarConexion();
    	
    	System.out.println("Sesion cerrada");
    }

	private static int menu() {	
		System.out.println("01. Insertar nueva reserva");
		System.out.println("02. Insertar nueva reserva y jugador.");
		System.out.println("03. Encontrar la primera reserva a partir de una determinada fecha y que no esté pagada.");
		System.out.println("04. Listar todas las reservas pagadas de jugadores del Sevilla");
		System.out.println("05. Listar todas las reservas anteriores a hoy que no estén pagadas.");
		System.out.println("06. Contar el número de socios que hay de una determinada ciudad");
		System.out.println("07. Mostrar los diferentes precios de las reservas ordenadas de forma creciente.");
		System.out.println("08. Sumar todos los precios de las reservas que no se han pagado todavía");
		System.out.println("09. Actualizar todas las reservas de jugadores de huelva cuyo anyo de inscripción sea menor que el 2008 para que el precio de la reserva esté al 50%.");
		System.out.println("10. Borrar todas las reservas pagadas y anteriores a este año.");
		System.out.print("Elija una opción: ");
		return sc.nextInt();
	}
	
	private static Reserva solicitarDatosReserva(){
    	Date fecha = pedirFecha();

    	System.out.println("-- PRECIO --");
    	System.out.print("Nuevo precio: ");
    	Double precio = sc.nextDouble();
    	
    	System.out.println("-- PAGADO --");
    	System.out.print("¿Está pagado ya la reserva? [Si/No]: ");
    	Boolean estaPagado = obtenerSiNo();
		
    	return  new Reserva(fecha, precio, estaPagado);
	}
	
	private static Boolean obtenerSiNo() {
		Boolean esPagada = null;

		do {
			String resp = sc.next();									// es una S
			if(resp.toLowerCase().equals("si") || resp.toLowerCase().equals("s"))
				return esPagada = true;
			else if(resp.toLowerCase().equals("no") || resp.toLowerCase().equals("n"))
				return esPagada = false;
			else{
				System.out.print("Repita de nuevo (Si/No): ");
			}
		} while (esPagada == null);
		return esPagada;
	}

	private static Jugador solicitarDatosJugador(){
		
		System.out.println("-- DATOS PERSONALES DEL JUGADOR --");
		System.out.println("Nombre: ");
		String nombre = sc.next();
		System.out.println("Apellidos: ");
		String apellidos = sc.next();
		System.out.println("Ciudad: ");
		String ciudad = sc.next();
		System.out.println("Año de inscripción: ");
		Integer anyo_inscripcion = sc.nextInt();
		System.out.println("Número de socio: ");
		Integer num_socio = sc.nextInt();
		
		return new Jugador(nombre, apellidos, ciudad, anyo_inscripcion, num_socio);
	}
	
	private static Date pedirFecha(){
    	Calendar fechaNueva = null;
    	Date fechaDate = null;
    	Integer hora = 12;
    	Integer minuto = 00;
    	
		do{
    		System.out.println("-- AÑADIR NUEVA RESERVA --");
        	System.out.println("-- FECHA --");
        	System.out.print("Día [1-31]: ");
        	Integer dia = obtenerEntero(1, 31);
        	System.out.print("Mes [1-12]: ");
        	Integer mes = obtenerEntero(1, 12);
        	System.out.print("Año [2000-2020]: ");
        	Integer anyo = obtenerEntero(2000, 2020);  
        	
        	System.out.print("¿Hora personalizada (En caso negativo se pondrá las 12:00)? [Si/No]: ");
        	Boolean eshora = obtenerSiNo();     	
        	if(eshora){
            	System.out.print("Hora [0-23]: ");
            	hora = obtenerEntero(0, 23);
            	System.out.println("Minutos [0-59]");
            	minuto = obtenerEntero(0, 59);
        	}
        	
        	try{        	  	
        		fechaNueva = GregorianCalendar.getInstance();
        		fechaNueva.set(anyo, mes - 1, dia, hora, minuto);
        	}catch (Exception e){
        		System.out.println(e);
        	}        	
    	}while(fechaNueva == null);
		
		SimpleDateFormat formatearDate = new SimpleDateFormat("dd/MM/yyyy 'a las' HH:mm");
	    System.out.println("Fecha final: " + formatearDate.format(fechaNueva.getTime()));
		
		//	Convertimos el calendar en Date para poder trabajar con la base de datos Mongo
		return fechaDate = fechaNueva.getTime();
	}
	
	private static Integer obtenerEntero(int min, int max) {
		Integer dia = -1;
		while (dia<min || dia >max) {	
			dia = sc.nextInt();
			if(dia<min || dia >max)
				System.out.print("Escriba un número dentro del intervalo ["+ min + "-" + max + "]: ");
		} 
		
		return dia;
	}

	private static void cargaReservas(){
    	
		Calendar c1 = null;
    	c1 = GregorianCalendar.getInstance();
		c1.set(2015, 2, 20);
		Calendar c2 = null;
    	c2 = GregorianCalendar.getInstance();
		c2.set(2015, 2, 22);
		Calendar c3 = null;
    	c3 = GregorianCalendar.getInstance();
		c3.set(2015, 2, 24);
		Calendar c4 = null;
    	c4 = GregorianCalendar.getInstance();
		c4.set(2015, 3, 15);
		Calendar c5 = null;
    	c5 = GregorianCalendar.getInstance();
		c5.set(2016, 5, 20);
		Calendar c6 = null;
    	c6 = GregorianCalendar.getInstance();
		c6.set(2016, 5, 25);
		Calendar c7 = null;
    	c7 = GregorianCalendar.getInstance();
		c7.set(2016, 6, 10);
		Calendar c8 = null;
    	c8 = GregorianCalendar.getInstance();
		c8.set(2014, 2, 9);
		
		c8.set(2015, 2, 9, 10, 15);
		
		Date date1 = c1.getTime();
		Date date2 = c2.getTime();
		Date date3 = c3.getTime();
		Date date4 = c4.getTime();
		Date date5 = c5.getTime();
		Date date6 = c6.getTime();
		Date date7 = c7.getTime();
		Date date8 = c8.getTime();
		
	 	Jugador j1 = new Jugador("Paco", "Sanchez", "Valencia", 2002, 9001);
    	Reserva r1 = new Reserva(date1, 100.5d, Boolean.TRUE);
     	Jugador j2 = new Jugador("Ana", "Terrón", "Sevilla", 2004, 9002);
    	Reserva r2 = new Reserva(date2, 50.5d, Boolean.FALSE);
     	Jugador j3 = new Jugador("Jesus", "Herrero", "Valencia", 2003, 9003);
    	Reserva r3 = new Reserva(date3, 75.5d, Boolean.TRUE);
     	Jugador j4 = new Jugador("Fernando", "Hortiz", "Sevilla", 2012, 9004);
    	Reserva r4 = new Reserva(date4, 80.5d, Boolean.TRUE);
    	Jugador j5 = new Jugador("Cristina", "Tenaz", "Huelva", 2012, 8001);
    	Reserva r5 = new Reserva(date5, 115.5d, Boolean.TRUE);
    	Jugador j6 = new Jugador("Pepe", "Cuña", "Huelva", 2006, 8002);
    	Reserva r6 = new Reserva(date6, 60.5d, Boolean.FALSE);
    	Jugador j7 = new Jugador("Jose", "Anton", "Madrid", 2011, 8003);
    	Reserva r7 = new Reserva(date7, 45.5d, Boolean.TRUE);
       	Jugador j8 = new Jugador("Raul", "Hierro", "Madrid", 2011, 8009);
    	Reserva r8 = new Reserva(date8, 190.5d, Boolean.FALSE);
    	
    	GestorBD.anyadirReservaYJugador(r1, j1);
    	GestorBD.anyadirReservaYJugador(r2, j2);
    	GestorBD.anyadirReservaYJugador(r3, j3);
    	GestorBD.anyadirReservaYJugador(r4, j4);
    	GestorBD.anyadirReservaYJugador(r5, j5);
    	GestorBD.anyadirReservaYJugador(r6, j6);
    	GestorBD.anyadirReservaYJugador(r7, j7);
    	GestorBD.anyadirReservaYJugador(r8, j8);
	}
	
	
}
