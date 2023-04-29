package com.bonsai.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.bonsai.admin.*", "com.bonsai.admin" })
@EnableJpaRepositories(basePackages = { "com.bonsai.admin.*" })
@EntityScan({ "com.bonsai.common.*" })
public class BonsaiBackEndApplication {

	public static void main(String[] args) {

		SpringApplication.run(BonsaiBackEndApplication.class, args);
		System.out.println("Okekekekeke");
	}

}
