package org.lba.springboot2.integration.activator;

import org.lba.springboot2.integration.lowlevel.LowLevelMessageManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class EmployeeSpringIntegrationServiceActivatorImpl implements EmployeeSpringIntegrationServiceActivator {

	 Logger LOGGER = LoggerFactory.getLogger(EmployeeSpringIntegrationServiceActivatorImpl.class);
	 
	 @Autowired
	 private LowLevelMessageManagement lowLevelMessageManagement;
	
	@ServiceActivator(inputChannel= "producerChannel")
	public void handleMessage(Object msg) {
		
		LOGGER.debug("Service activator for producer");
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
		/**/
		String jsonInString = gson.toJson(msg);
	}
}
