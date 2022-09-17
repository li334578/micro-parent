package com.example.microproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.microcommon","com.example.microproduct"})
public class MicroProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroProductApplication.class, args);
    }

}
