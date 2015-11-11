package es.altair.springdata.template;

import java.util.ArrayList;
import java.util.List;

//	9.	
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.mongodb.DuplicateKeyException;

import es.altair.springdata.config.MongoConfig;
import es.altair.springdata.domain.Cliente;
import es.altair.springdata.domain.Direccion;
import es.altair.springdata.repository.ClienteRepository;

//	1.	
@Component
public class Principal {

	//	2.	Es un objeto que nos permite trabajar con la base de datos
	//	Te auto inicializa el mongoOps
	@Autowired
	private MongoOperations mongoOps;
	
	public static void main(String[] args) {
		//	3.	Nos permite traer el contexto de la localizacion y nombre de la bd en el mongoconfig ya creado
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		
		//	5.	
		Principal p = ctx.getBean(Principal.class);
		p.metodos();
		
		
		//	11.	Para trabajar con los repositorios
		ClienteRepository repoCliente = ctx.getBean(ClienteRepository.class);
				
		//	4.	
		ctx.close();
	}

	private void metodos() {
		
		//	6.	Trabajamos fuera del main porque no podemos establecer el MongoOperations como static
		Cliente c1 = new Cliente(1, "yo", "altair", 45, 23225, new Direccion(1, "mi calle", "sevilla"));
		Cliente c2 = new Cliente(2, "tu", "altair", 55, 33225, new Direccion(2, "tu calle", "sevilla"));
		Cliente c3 = new Cliente(3, "el", "unos", 65, 43225, new Direccion(3, "su calle", "huelva"));
		Cliente c4 = new Cliente(3, "el", "unos", 65, 43225, new Direccion(3, "su calle", "huelva"));

		
		List<Cliente> lista = new ArrayList<Cliente>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		
//		try {
//			
//			mongoOps.insert(lista, Cliente.class);
//			
//		} catch (DuplicateKeyException e){
//			System.out.println("Id Repetidos");
//		}
		
		List<Cliente> clientes = mongoOps.findAll(Cliente.class);
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}		
		
		System.out.println("Por Nombre: " + mongoOps.findOne(query(where("nombre").is("yo")), Cliente.class));
		System.out.println("Por Nombre: " + repocl);
	}

}
