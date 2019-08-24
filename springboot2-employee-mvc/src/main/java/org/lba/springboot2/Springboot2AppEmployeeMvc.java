package org.lba.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.lba.springboot2.db.repository")
@ComponentScan({"org.lba.springboot2"})
@EntityScan("org.lba.springboot2.db.model")
public class Springboot2AppEmployeeMvc {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2AppEmployeeMvc.class, args);
	}
	
	@Bean
	@Description("Spring Message Resolver")
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}

}
