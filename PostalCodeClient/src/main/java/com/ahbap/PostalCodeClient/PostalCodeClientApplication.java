package com.ahbap.PostalCodeClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ahbap")
@EntityScan(basePackages = "com.ahbap")
@EnableJpaRepositories(basePackages = "com.ahbap")
public class PostalCodeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostalCodeClientApplication.class, args);
	}

}
