package com.bonsai.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.bonsai.client.*", "com.bonsai.client" })
@EnableJpaRepositories(basePackages = { "com.bonsai.client.*" })
@EntityScan({ "com.bonsai.common.*" })
public class BonsaiApplication {

	public static void main(String[] args) {

		SpringApplication.run(BonsaiApplication.class, args);
		System.out.println("Okekekekeke");
	}

}
