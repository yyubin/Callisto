package com.spring.callistoreview;

import com.spring.callistoreview.db.entity.Industry;
import com.spring.callistoreview.db.repository.IndustryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CallistoReviewApplication implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(CallistoReviewApplication.class, args);

    }

    @Override
    public void run(String... ars) throws Exception {
        restTemplate.getForObject("http://localhost:8666/example-data", String.class);
    }

}