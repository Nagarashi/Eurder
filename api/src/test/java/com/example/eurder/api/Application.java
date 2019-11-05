package com.example.eurder.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.eurder")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
