package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.repository")
@ComponentScan
public class FaqServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaqServerApplication.class, args);
	}

}
