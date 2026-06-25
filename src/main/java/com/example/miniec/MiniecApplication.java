package com.example.miniec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.example.miniec")
public class MiniecApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniecApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
