package com.application.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.application.backend","com.application.DAO","com.application.mapper"})
public class MainApplication {

	public static void main(String[] args) {
		System.out.println("......starting Tplanner's Spring Boot Applictrion...");
		SpringApplication.run(MainApplication.class, args);
	}
}
