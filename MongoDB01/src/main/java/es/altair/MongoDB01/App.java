package es.altair.MongoDB01;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.basic.BasicArrowButton;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
//import com.mongodb.ServerAddress;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	MongoClient cliente = null;
    	
    	try {
    		//	Para conectarse a un unico equipo con MondoDB Server
			cliente = new MongoClient("localhost", 27017);
			
			//	Para conectarse con varia instacias de MongoDB hacemos una Arrays de servidores
			//	MongoClient cliente2 = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017), new ServerAddress()));

			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
		for(String nombreBD :cliente.getDatabaseNames()){
			System.out.println(nombreBD);
		}
		
		DB basededatos = cliente.getDB("mibase");
		DBCollection coleccion = basededatos.getCollection("usuarios");
		BasicDBObject documento = new BasicDBObject("nombre", "dani");
		coleccion.insert(documento);
		
		coleccion.drop();
//		
//		for(String colnames : basededatos.getCollectionNames()){
//			System.out.println(colnames);
//		}
//		
//		//	Para eleminar una coleccion
//		coleccion.drop();
		
//		DBCollection coleccion = basededatos.createCollection("usuarios", new BasicDBObject());
		
//		cliente.dropDatabase("mibase");
		
		BasicDBObject documento2 = new BasicDBObject();
		documento2.put("nombre", "yo");
		documento2.put("pais", "españa");
		documento2.put("anyo", 2015);
		documento2.put("fecha", new Date());
		documento2.put("activado", true);
		coleccion.insert(documento2);
		
		BasicDBObject documento3 = new BasicDBObject();
		documento3.put("nombre", "tu");
		documento3.put("aficiones", Arrays.asList("deportes", "musica", "lectura"));
		documento3.put("anyo", 2013);
		coleccion.insert(documento3);
		
		
		BasicDBObject documento4 = new BasicDBObject();
		documento4.put("nombre", "el");
		documento4.put("otra informacion", new BasicDBObject("domicilio", "mi calle")
				.append("cod postal", "41000")
				.append("ciudad", "sevilla"));
		documento4.put("anyo", 2015);
		documento4.put("pais", "españa");
		coleccion.insert(documento4);
		
		
//		coleccion.insert(Arrays.asList(documento2, documento3, documento4));
		
//		BasicDBObject documento5 = new BasicDBObject();
//		documento5.put("_id", "1");
//		documento5.put("nombre", "lolol");
//		coleccion.insert(documento3);
//		
//		BasicDBObject documento6 = new BasicDBObject();
//		documento6.put("_id", "1");
//		documento6.put("nombre", "lolol");		
//		coleccion.insert(documento3);
		
		
		//	Encuentra el primero de la colección
		DBObject primero = coleccion.findOne();
		System.out.println(primero);
		
		
		//	Para recorrer toda la coleccion con un cursor
		DBCursor cursor = coleccion.find();
		while(cursor.hasNext()){
			DBObject obj = cursor.next();
			System.out.println("Nombre: " + obj.get("nombre"));
		}
		cursor.close();
		
		//	Consulta que cuente los uusarios españoles pasandole las campos que quiere contar, en este caso la 
		//	key pais y el valor españa
		//	El operador mayor que es $gt y menor que $lt
		System.out.println("Nº Usuarios españoles: " + coleccion.count(new BasicDBObject("pais", "españa")
				.append("anyo", new BasicDBObject("$gt", 2000)
						.append("$lt", 2016))));
		
		
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(2013);
		lista.add(2014);
		lista.add(2015);
		
		DBCursor cursor2 = coleccion.find(new BasicDBObject().append("anyo", new BasicDBObject("$in", lista)));
		
		while (cursor2.hasNext()) {
			DBObject obj = cursor2.next();
			System.out.println(obj);
			System.out.println("Nombre: " + obj.get("nombre"));
			
		}
		cursor2.close();
		
		//	Listar todos los usuarios que son de españa
		BasicDBObject query1 = new BasicDBObject("pais", "españa");
		BasicDBObject query2 = new BasicDBObject("pais", "italia");
		ArrayList<BasicDBObject> lista2 = new ArrayList<BasicDBObject>();
		
		lista2.add(query1);
		lista2.add(query2);
		DBCursor cursor3 = coleccion.find(new BasicDBObject("$or", lista2));
		
		System.out.println("Buscaqueda 3ra: ");
		
		while (cursor3.hasNext()) {
			DBObject obj = cursor3.next();
			System.out.println(obj);
			System.out.println("Nombre: " + obj.get("nombre"));
			
		}
		cursor3.close();
		
    }
}
