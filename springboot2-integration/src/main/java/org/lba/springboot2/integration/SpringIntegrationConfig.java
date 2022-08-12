package org.lba.springboot2.integration;

import org.lba.springboot2.integration.activator.EmployeeSpringIntegrationErrorServiceActivator;
import org.lba.springboot2.integration.activator.EmployeeSpringIntegrationErrorServiceActivatorImpl;
import org.lba.springboot2.integration.activator.EmployeeSpringIntegrationServiceActivator;
import org.lba.springboot2.integration.activator.EmployeeSpringIntegrationServiceActivatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class SpringIntegrationConfig {

	@Bean
	public MessageChannel producerChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel errorChannel() {
		return new DirectChannel();
	}

	/**/
	@Bean
	public EmployeeSpringIntegrationServiceActivator employeeSpringIntegrationServiceActivator() {
		
		return new EmployeeSpringIntegrationServiceActivatorImpl();
	}
	
	@Bean
	
	public EmployeeSpringIntegrationErrorServiceActivator employeeSpringIntegrationErrorServiceActivatorImpl() {
		
		return new EmployeeSpringIntegrationErrorServiceActivatorImpl();
	}
}
