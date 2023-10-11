package com.generateToken.generateToken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class GenerateTokenApplication {

	public static void main(String[] args) {

		SpringApplication.run(GenerateTokenApplication.class, args);

	}
}
