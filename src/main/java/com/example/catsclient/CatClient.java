package com.example.catsclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class CatClient {
    @Autowired
    private final RestTemplate restTemplate;

    public CatClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Cats findByName(String name){
        return restTemplate.getForObject("http://localhost:8080/cats/{name}",Cats.class,name);
    }
}
