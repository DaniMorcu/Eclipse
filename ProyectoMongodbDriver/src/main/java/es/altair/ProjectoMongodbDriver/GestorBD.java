package es.altair.ProjectoMongodbDriver;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Updates.mul;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class GestorBD {

	private static MongoClient cliente;
	private static MongoDatabase basededatos;
	private static MongoCollection<Document> coleccion;
	
	public static void conexionBD(){
		cliente = new MongoClient(new ServerAddress("localhost", 27017));
		basededatos = cliente.getDatabase("reservasbd");
	}
	
	public static void crearColeccionReserva(){
		coleccion = basededatos.getCollection("reserva");
	}
	
	public static void cerrarConexion(){
		cliente.close();
	}
	
	public static void anyadirReserva(Reserva reserva){
		Document documento = new Document("_id", new ObjectId())
				.append("fecha", reserva.getFecha())
				.append("precio", reserva.getPrecio())
				.append("esPagado", reserva.getEsPagada());
		
		coleccion.insertOne(documento);
	}
	
	public static void anyadirReservaYJugador(Reserva reserva, Jugador jugador){
		Document documento = new Document("_id", new ObjectId())
				.append("fecha", reserva.getFecha())
				.append("precio", reserva.getPrecio())
				.append("esPagado", reserva.getEsPagada())
				.append("Caracteristicas jugador", 
						new Document("nombre", jugador.getNombre())
						.append("apellidos", jugador.getApellidos())
						.append("ciudad", jugador.getCiudad())
						.append("anyo de inscripcion", jugador.getAnyo_inscripcion())
						.append("numero de socio", jugador.getNum_socio()));
		
		coleccion.insertOne(documento);
	}
	
	public static void encontrarReservaYNoPagada(Date fechaBuscar){		
		
		System.out.println("-- PROXIMA RESERVA NO PAGADA --");
		Document doc = coleccion.find(and(eq("esPagado", Boolean.FALSE), 
				gt("fecha", fechaBuscar))).sort(ascending("fecha")).first();
		
		System.out.println(doc);
	}

	public static void listarReservasAnterioresHoyNoPagadas() {
		
		System.out.println("-- LISTADO DE RESERVAS ANTERIORES NO PAGADAS --");
		Date date = new Date();
		
		Block<Document> pBlock = new Block<Document>() {
			public void apply(Document doc) {
				System.out.println(doc);				
			}
		};
		
		coleccion.find(and(eq("esPagado", Boolean.FALSE), lt("fecha", date))).sort(descending("fecha")).forEach(pBlock);
		
	}

	public static void listarReservasPagadasSevilla() {		
		
		System.out.println("-- LISTADO DE RESERVAS PAGADAS POR JUGADORES DEL SEVILLA --");
		Block<Document> pBlock = new Block<Document>() {
			public void apply(Document doc) {
				System.out.println(doc);				
			}
		};
		coleccion.find(and(eq("esPagado", Boolean.TRUE), eq("Caracteristicas jugador.ciudad", "Sevilla"))).forEach(pBlock);		
	}

	public static void contarSociosCiudad(String ciudad) {

		System.out.println("-- NUMEROS DE SOCIOS EN " + ciudad.toUpperCase() + " --" );
		System.out.println("Total de socios: " + coleccion.count(eq("Caracteristicas jugador.ciudad", ciudad)));
		
	}

	public static void listarPreciosOrdenadosCrec() {
		Set<Double> conjuntoOrdenadoPrecios = new TreeSet<Double>();
		for(Document doc : coleccion.find()){
			conjuntoOrdenadoPrecios.add(doc.getDouble("precio"));
		}
		for (Double precio : conjuntoOrdenadoPrecios) {
			System.out.println(precio);
		}
	}

	public static void sumarReservasNoPagadas() {
		Double sumaPrecios = 0d;
		System.out.println("-- SUMA DE LAS RESERVAS NO PAGADAS AUN --");		
		for(Document doc : coleccion.find(eq("esPagado", Boolean.FALSE))){
			sumaPrecios += doc.getDouble("precio");
		}
		System.out.println("El total asciende a " + sumaPrecios + " Euros");
	}

	public static void actualizarHuelvaAnyo2008() {
		//	Actualizar RESERVAS y HUELVA y AÑO INSCRIPCION < 2008 para PRECIO 50% DESCUENTO
		System.out.println("-- REBAJA DEL 50% EN RESERVAS DE HUEVLA CON AÑO DE INSCRIPCION ANTERIOR AL 2008 --");	
		UpdateResult result = coleccion.updateMany(and(eq("Caracteristicas jugador.ciudad", "Huelva"), 
				lt("Caracteristicas jugador.anyo de inscripcion", 2008)), mul("precio", 0.50d));
		System.out.println("Se han actualizado " + result.getModifiedCount() + "reservas");
	
	}

	public static void borrarPagadasAnteioresAnyo() {
		Date hoy = new Date(); // Hoy
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(hoy);
	    //	Obtenemos el año actual
	    int anyo = cal.get(Calendar.YEAR);

	    System.out.println("Año ACTUAL : " + anyo);
	    //	Calentadario para comparar
	    Calendar compareCal = null;
	    compareCal = GregorianCalendar.getInstance();
	    compareCal.set(anyo, 0, 1);
	    
	    //	Lo convertimos en Date para trabajar con el
	    Date dateComp = compareCal.getTime();
	    
	    System.out.println("FECHA A COMPARAR: " + dateComp);
		
		DeleteResult result = coleccion.deleteMany(and(eq("esPagado", Boolean.TRUE), lt("fecha", dateComp)));
		System.out.println("-- SUMA DE LAS RESERVAS NO PAGADAS AUN --");	
		System.out.println("Se han borrado " + result.getDeletedCount() + " reservas");
		
	}
	
	
	
}






































