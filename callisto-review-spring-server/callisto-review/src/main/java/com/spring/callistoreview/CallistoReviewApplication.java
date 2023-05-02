package com.spring.callistoreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CallistoReviewApplication implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(CallistoReviewApplication.class, args);

    }

    @Override
    public void run(String... ars) throws Exception {
        String result = restTemplate.getForObject("http://localhost:8666/example-data", String.class);
        System.out.println(result);
    }

}
