package com.mongodb.apachecamel.MongoDB_ApacheCamel.route;

import com.mongodb.apachecamel.MongoDB_ApacheCamel.model.ClientDb;
import com.mongodb.apachecamel.MongoDB_ApacheCamel.processor.ClientProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import static javax.ws.rs.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



@Slf4j
@Component
public class ClientDbRoute extends RouteBuilder {

    @Autowired
    private ClientProcessor clientProcessor;

    public ClientDbRoute(ClientProcessor clientProcessor) {
        this.clientProcessor = clientProcessor;
    }

    @Override
    public void configure() throws Exception{
        rest("/")
                .post("/client")
                .id("direct-client")
                .toD("direct:client");
       from("direct:client")
               .process(clientProcessor).marshal().json(JsonLibrary.Jackson, ClientDb.class)
               .setHeader(Exchange.HTTP_METHOD, simple(POST))
               .setHeader(Exchange.CONTENT_TYPE, constant(APPLICATION_JSON_VALUE))
               .log("Message received from mongodb : ${body}")
               .toD("direct:insertMongoDb")
               .end();
        from("direct:insertMongoDb").routeId("insertMongoDb")
                .log("Message from mongodb connection : ${body}")
                .process(exchange -> {clientProcessor.process(exchange);
                })
                .toD("mongodb+srv:mongoClient?database=mongocamel&collection=client-processor&operation=insert");

    }
}
