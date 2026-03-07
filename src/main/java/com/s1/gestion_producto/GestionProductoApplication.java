package com.s1.gestion_producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class GestionProductoApplication {


	public static void main(String[] args) {
		SpringApplication.run(GestionProductoApplication.class, args);
        System.out.println("hola");
	}
}
