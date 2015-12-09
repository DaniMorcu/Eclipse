package es.altair.springdata.template;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import es.altair.springdata.config.MongoConfig;
import es.altair.springdata.domain.Jugador;
import es.altair.springdata.domain.Reserva;
import es.altair.springdata.repository.ReservaRepository;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.*;

@Component
public class Principal {

	@Autowired
	private MongoOperations mongoOperations;

	private static ReservaRepository repoReserva;
//	private static JugadorRepository repoJugador;
	
	private static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		
		repoReserva = ctx.getBean(ReservaRepository.class);
//		repoJugador = ctx.getBean(JugadorRepository.class);
		
		Principal principal = ctx.getBean(Principal.class);
		
		//	Metodo donde realizaremos todas las consultas y peticiones
		principal.programa();
		
		ctx.close();
	}

	private void programa() {
//		Calendar c1 = null;
//    	c1 = GregorianCalendar.getInstance();
//		c1.set(2025, 9, 9);
//		
//		Date date1 = c1.getTime();
//		
//		Reserva r1 = new Reserva(date1, 1000.50d, Boolean.TRUE);
//		mongoOperations.insert(r1);
//		
//		System.out.println("R1 insertado");
		
//		cargaReservas();
		
		int opcion = 0;
		do {
			opcion = menu();
			switch (opcion) {
			case 1:	//	INSERTAR RESERVA
				mongoOperations.insert(solicitarDatosReserva());
				break;
			case 2:	//	INSERTAR RESERVA y JUGADOR
				Reserva r = solicitarDatosReserva();
				Jugador j = solicitarDatosJugador();	
				Reserva ryj = new Reserva(r, j);
				mongoOperations.insert(ryj);
				break;
			case 3:	//	PRIMERA RESERVA de una determinada FECHA y NO ESTA PAGADA
				Date fecha = pedirFecha();
				System.out.println("PRIMERA RESERVA ENCONTRADA NO PAGADA: ");
				System.out.println(repoReserva.findByFechaGreaterThanAndEsPagada(fecha, Boolean.TRUE));
				break;
			case 4:	//	Listar RESERVAS PAGADAS y SEVILLA
				System.out.println("RESERVA PAGADAS EN SEVILLA: ");
				for(int i = 0; i<repoReserva.findByEsPagadaAndJugadorCiudad(Boolean.TRUE, "Sevilla").size(); i++)
					System.out.println(repoReserva.findByEsPagadaAndJugadorCiudad(Boolean.TRUE, "Sevilla").get(i));
				break;
			case 5:	//	Listar RESERVAS ANTERIORES y NO PAGADAS
				System.out.println("RESERVAS ANTERIORES A HOY Y NO PAGADAS");
				Date hoy = new Date();
				for(int i = 0; i<repoReserva.findByEsPagadaAndFechaLessThan(Boolean.FALSE, hoy).size(); i++)
					System.out.println(repoReserva.findByEsPagadaAndFechaLessThan(Boolean.FALSE, hoy).get(i));
				break;
			case 6:	//	CONTAR SOCIOS y CIUDAD
				System.out.println("CONTAR SOCIOS Y CIUDAD");
				System.out.print("Escriba la ciudad: ");
				String ciudad = sc.next();
				System.out.println("El total de socios de " + ciudad + ": "+ mongoOperations.count(query(where("jugador.ciudad").is(ciudad)), Reserva.class));
				break;
			case 7:	//	Listar PRECIOS ORDENADOS CRECIENTE
				System.out.println("LISTA DE PRECIOS ORDENADA");
				Set<Double> conjuntoOrdenadoPrecios = new java.util.TreeSet<Double>();
				for(Reserva reserva : repoReserva.findByPrecioIsNotNull()){
					conjuntoOrdenadoPrecios.add(reserva.getPrecio());
				}
				
				for (Double precio : conjuntoOrdenadoPrecios) {
					System.out.println(precio);
				}
				break;
			case 8:	//	SUMAR todas las RESERVAS y NO PAGADAS
				Double sumaPrecios = 0d;
				System.out.println("-- SUMA DE LAS RESERVAS NO PAGADAS AUN --");		
				for(Reserva reserva : repoReserva.findByEsPagadaIs(Boolean.FALSE)){
					sumaPrecios += reserva.getPrecio();
				}
				System.out.println("La suma total es " + sumaPrecios + " Euros");
				break;
			case 9:	//	Actualizar RESERVAS y HUELVA y AÑO INSCRIPCION < 2008 para PRECIO 50% DESCUENTO	
				Query query1 = new Query();
				query1.addCriteria(where("jugador.ciudad").is("Huelva"));
				query1.addCriteria(where("jugador.anyo de inscripcion").lt(2008));
				mongoOperations.updateMulti(query1, new org.springframework.data.mongodb.core.query.Update().multiply("precio",	0.5d) , Reserva.class);
				System.out.println("Base de datos actualizada con los descuentos.");
				break;
			case 10:	//	BORRAR RESERVAS PAGADAS y ANTERIORES A ESTE AÑO
				Date dateHoy = new Date(); // Hoy
			    Calendar cal = Calendar.getInstance();
			    cal.setTime(dateHoy);
			    
			    //	Obtenemos el año actual
			    int anyo = cal.get(Calendar.YEAR);
			    System.out.println("Año ACTUAL : " + anyo);
			    
			    //	Calentadario para comparar
			    Calendar compareCal = null;
			    compareCal = GregorianCalendar.getInstance();
			    // Establecemos el 1 de Enero del año Actual
			    compareCal.set(anyo, 0, 1);
			    
			    //	Lo convertimos en Date para trabajar con el
			    Date dateComp = compareCal.getTime();
				
				Query query2 = new Query();
				query2.addCriteria(where("esPagada").in(Boolean.TRUE));
				query2.addCriteria(where("fecha").lt(dateComp));
				mongoOperations.remove(query2, Reserva.class);
				break;
			default:
				System.out.println("Opción incorrecta. Teclee un número entre 0 y 10");
				break;
			}
		} while (opcion != 0);
		
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
			String resp = sc.next();
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
		do{
    		System.out.println("-- AÑADIR NUEVA RESERVA --");
        	System.out.println("-- FECHA --");
        	System.out.print("Día [1-31]: ");
        	Integer dia = obtenerEntero(1, 31);
        	System.out.print("Mes [1-12]: ");
        	Integer mes = obtenerEntero(1, 12);
        	System.out.print("Año [2000-2020]: ");
        	Integer anyo = obtenerEntero(1999, 2021);   
        	try{        	  	
        		fechaNueva = GregorianCalendar.getInstance();
        		fechaNueva.set(anyo, mes - 1, dia);
        	}catch (Exception e){
        		System.out.println(e);
        	}        	
    	}while(fechaNueva == null);
		
		SimpleDateFormat formatearDate = new SimpleDateFormat("dd/MM/yyyy");
	    System.out.println("Fecha final: " + formatearDate.format(fechaNueva.getTime()));
		
		//	Convertimos el calendar en Date para poder trabajar con la base de datos Mongo
		return fechaDate = fechaNueva.getTime();
	}
	
	private static Integer obtenerEntero(int min, int max) {
		Integer dia = 0;
		while (dia<min || dia>max) {	
			dia = sc.nextInt();
			if(dia<min || dia >max)
				System.out.print("Escriba un número dentro del intervalo ["+ min + "-" + max + "]: ");
		} 
		
		return dia;
	}
	
	private void cargaReservas() {
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
    	
    	Reserva ryj1 = new Reserva(r1, j1);
    	Reserva ryj2 = new Reserva(r2, j2);
    	Reserva ryj3 = new Reserva(r3, j3);
    	Reserva ryj4 = new Reserva(r4, j4);
    	Reserva ryj5 = new Reserva(r5, j5);
    	Reserva ryj6 = new Reserva(r6, j6);
    	Reserva ryj7 = new Reserva(r7, j7);
    	Reserva ryj8 = new Reserva(r8, j8);
    	
    	mongoOperations.insert(ryj1);
    	mongoOperations.insert(ryj2);
    	mongoOperations.insert(ryj3);
    	mongoOperations.insert(ryj4);
    	mongoOperations.insert(ryj5);
    	mongoOperations.insert(ryj6);
    	mongoOperations.insert(ryj7);
    	mongoOperations.insert(ryj8);

	}
}
