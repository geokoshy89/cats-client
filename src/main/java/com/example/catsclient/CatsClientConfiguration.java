package com.example.catsclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CatsClientConfiguration {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
