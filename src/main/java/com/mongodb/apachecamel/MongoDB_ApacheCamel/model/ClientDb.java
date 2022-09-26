package com.mongodb.apachecamel.MongoDB_ApacheCamel.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "client-processor")
public class ClientDb {

    @Id
    private String code;
    private String message;
    private String detail;

}
