package com.quickret.apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	    "com.quickret.api.controllers",
	    "com.quickret.services",
	    "com.quickret.apis"
	})
public class QuickretBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickretBackendApplication.class, args);
	}

}
