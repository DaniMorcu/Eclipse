package es.altair.mongodb02;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.*;
import static com.mongodb.client.model.Updates.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.html.BlockView;

public class GestoBD {

	private static MongoClient cliente;
	private static MongoDatabase basededatos;
	private static MongoCollection<Document> coleccion;

	public static void conexionBD() {
		cliente = new MongoClient(new ServerAddress("localhost", 27017));
		basededatos = cliente.getDatabase("bbdd");
	}

	public static void crearColeccion() {
		coleccion = basededatos.getCollection("libros");
	}

	public static void cerrarConexion() {
		cliente.close();
	}

	public static void anyadirLibro(Libro libro) {

		Document documento = new Document("_id", new ObjectId()).append("titulo", libro.getTitulo())
				.append("numero de paginas", libro.getNumPag()).append("editorial", libro.getEditorial())
				.append("año de publicacion", libro.getAnyoPubli()).append("otras caracteristicas",
						new Document("web de referencia", libro.getWeb()).append("precio", libro.getPrecio()));

		coleccion.insertOne(documento);
	}

	public static void buscarPagsAnyo() {
		Document documento = coleccion.find(and(gt("numero de paginas", 200), eq("anyo de publicacion", 2014))).first();

		System.out.println(documento);
	}

	public static void todosAnaya() {

		Block<Document> printBlock = new Block<Document>() {
			
			public void apply(Document doc) {
				System.out.println(doc);
			}
		};
												// el forEach para que muestre todos
		coleccion.find(eq("editorial", "Anaya")).forEach(printBlock);
	}

	public static void contarMayor20() {

		System.out.println("Numero de libros mayor que 20€: " + coleccion.count(gt("otras caracteristicas.precio", 20)));
	}

	public static void librosConWeb() {
		Block<Document> printBlock = new Block<Document>() {
			
			public void apply(Document doc) {
				System.out.println(doc);
			}
		};
		
		coleccion.find(exists("otras caracteristicas.web de referencia")).forEach(printBlock);
	}

	public static void librosOrdenadosPorPrecio() {

		// Cada vez que hacemos un SELECT * FROM .... hacemos un block
		
		Block<Document> printBlock = new Block<Document>() {
			
			public void apply(Document doc) {
				System.out.println(doc);
			}
		};
		
		coleccion.find().sort(ascending("otras caracteristicas.precio")).forEach(printBlock);
	}

	public static void incrementarPrecio() {

		
		// REVISAR
//		UpdateResult resultado = coleccion.updateMany(or(eq("anyo publicacion", 2010),
//				eq("anyo publicacion", 2012), 
//				eq("anyo publicacion", 2014), 
//				inc("otras catacteristicas.precio", 2)));
//			
//		System.out.println("Numero de libros incrementados: " + resultado.getModifiedCount());
		
//		List<Integer> lista = new ArrayList<Integer>();
//		lista.add(2010);
//		lista.add(2012);
//		lista.add(2014);
		//...
	}

	public static void borradoPrecioPaginaCero() {

		DeleteResult resultado =  coleccion.deleteMany(or(eq("otras caracteristicas.precio", 0), 
				eq("numero de paginas", 0)));
		System.out.println("Libros borrados: " + resultado.getDeletedCount());
	}



}
