package com.unifood.entregador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class EntregadorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntregadorServiceApplication.class, args);
    }
}
