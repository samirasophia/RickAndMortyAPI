package com.example.rickandmortyapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class RmApplication {

    public static void main(String[] args) {
        SpringApplication.run(RmApplication.class, args);
    }

    @Bean
    WebClient defineWebClient(){
        return WebClient.builder().baseUrl("https://rickandmortyapi.com").build();
    }


}
