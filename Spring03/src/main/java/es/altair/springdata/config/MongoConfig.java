package es.altair.springdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

// 	1.	Necesita 
@Configuration
@EnableMongoRepositories(basePackages="es.altair.springdata.repository")
@ComponentScan(basePackages="es.altair.springdata.template")
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		//	2.	nombre de la bbdd
		return "persondirect";
	}
	
	//	4.	Para que sepa que es un objeto
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		//	3.	URL del servidor mongo
		MongoClient cliente = new MongoClient("localhost");
		return cliente;
	}

	//	5.	Para que sepa spring donde estan los bean (objetos) de nuestro servidor
	@Override
	protected String getMappingBasePackage() {
		// 	6.	Borramos el super y añadimos nuestro package	
		return "es.altair.springdata.domain";
	}
	
	//	7.	Declaramos como objeto
	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		// 	8.	Borrramos super. Esto es para el mongo operation para hacer inserciones, updates 
		//	sobre nuestra bbdd 
		return new MongoTemplate(mongo(), getDatabaseName());
	}
}
