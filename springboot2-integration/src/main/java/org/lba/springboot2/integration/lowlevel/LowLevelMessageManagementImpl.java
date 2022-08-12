package org.lba.springboot2.integration.lowlevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LowLevelMessageManagementImpl implements LowLevelMessageManagement{

	Logger LOGGER = LoggerFactory.getLogger(LowLevelMessageManagementImpl.class);
	
	@Override
	public void manageMessage(Object msg) {
		LOGGER.debug("Message managed at low level");
		
	}

}
