package com.evaluacion2.porcentajeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PorcentajeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PorcentajeServiceApplication.class, args);
	}

}
