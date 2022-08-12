package org.lba.springboot2.integration.activator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;

public class EmployeeSpringIntegrationErrorServiceActivatorImpl implements EmployeeSpringIntegrationErrorServiceActivator {

	Logger logger = LoggerFactory.getLogger(EmployeeSpringIntegrationErrorServiceActivatorImpl.class);

	@Override
	@ServiceActivator(inputChannel= "errorChannel")
	public void handleErrorMessage(Object msg) {
		// TODO Auto-generated method stub

	}
}
