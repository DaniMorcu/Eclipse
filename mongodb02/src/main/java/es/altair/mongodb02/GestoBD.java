package es.altair.mongodb02;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

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

		coleccion.count();
	}

}
