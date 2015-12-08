package es.altair.springdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="es.altair.springdata.repository")
@ComponentScan(basePackages="es.altair.springdata.template")
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "reservasbd";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoClient cliente = new MongoClient("localhost");
		return cliente;
	}
	@Override
	protected String getMappingBasePackage() {
		return "es.altair.springdata.domain";
	}
	
	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}

}
