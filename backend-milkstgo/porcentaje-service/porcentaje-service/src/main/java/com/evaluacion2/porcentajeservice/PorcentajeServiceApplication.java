package com.evaluacion2.porcentajeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PorcentajeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PorcentajeServiceApplication.class, args);
	}

}
