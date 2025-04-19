package com.example.Hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RetryReplayApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetryReplayApplication.class, args);
    }
}
