package com.mongodb.apachecamel.MongoDB_ApacheCamel.processor;

import com.mongodb.apachecamel.MongoDB_ApacheCamel.model.ClientDb;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClientProcessor implements Processor {

     public void process(Exchange exchange) throws Exception{
          final ClientDb clientDB = new ClientDb();
                 clientDB.setCode("OYAOO12");
                 clientDB.setMessage("Erro ao processamento");
                 clientDB.setDetail("Tente novamente mais tarde");
                 exchange.getIn().setBody(clientDB);

     }

}
