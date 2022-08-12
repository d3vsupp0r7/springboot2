package org.lba.springboot2.activemq.consumer;

import org.lba.springboot2.activemq.config.RetryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMQConsumer.class);
	
	@Autowired
	private RetryConfig retry;

	@JmsListener(destination = "${activemq.queue}")
	public void consumeMessage(String message) {
		LOGGER.info("CONSUMER: Message received from activemq queue:\n" + message);
		try {
			retry.retryConfig();
		} catch (Exception e) {
			LOGGER.info("INSIDE EXCEPTION: ActiveMQConsumer->consumeMessage\n" + message);
			e.printStackTrace();
		}
	}

}
