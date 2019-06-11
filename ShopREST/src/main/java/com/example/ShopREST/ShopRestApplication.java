package com.example.ShopREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ShopRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopRestApplication.class, args);
	}

}
