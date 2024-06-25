package com.raven.springbootonetoonemapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
// @ComponentScan(basePackageClasses = MotorcycleController.class)
public class SpringbootonetoonemappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootonetoonemappingApplication.class, args);
		System.out.println("Application started...");
	}

}
