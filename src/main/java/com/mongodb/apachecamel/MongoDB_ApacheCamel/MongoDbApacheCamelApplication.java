package com.mongodb.apachecamel.MongoDB_ApacheCamel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class})
public class MongoDbApacheCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApacheCamelApplication.class, args);
	}

}
