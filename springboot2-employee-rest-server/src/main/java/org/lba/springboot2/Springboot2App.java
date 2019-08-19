package org.lba.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.lba.springboot2.db.repository")
@ComponentScan({"org.lba.springboot2"})
@EntityScan("org.lba.springboot2.db.model")
public class Springboot2App {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2App.class, args);
	}

}
