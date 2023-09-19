package com.jairoprogramador.reactor.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactorApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(ReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ejemplos ejemplos = new Ejemplos();
		ejemplos.ejemplo01();
	}
}
