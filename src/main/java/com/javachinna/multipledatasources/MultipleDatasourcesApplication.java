package com.javachinna.multipledatasources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.javachinna")
public class MultipleDatasourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatasourcesApplication.class, args);
	}

}
