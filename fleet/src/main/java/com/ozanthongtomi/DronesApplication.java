package com.ozanthongtomi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ozanthongtomi.drones.controller", "com.ozanthongtomi.drones.model", "com.ozanthongtomi.drones.repository", "com.ozanthongtomi.drones.service", "com.ozanthongtomi.pizzeria"})
public class DronesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DronesApplication.class, args);
		System.out.println("pepe");
	}

}
