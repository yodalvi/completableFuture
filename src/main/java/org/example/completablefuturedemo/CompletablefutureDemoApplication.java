package org.example.completablefuturedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CompletablefutureDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompletablefutureDemoApplication.class, args);
    }

}
