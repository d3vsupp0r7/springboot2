package org.lba.springboot2.activemq.config;

import org.lba.springboot2.activemq.consumer.ActiveMQConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

@Configuration
@EnableRetry
public class RetryConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMQConsumer.class);

	@Retryable(value = Exception.class, maxAttemptsExpression = "${retry.maxAttempts:3}", backoff = @Backoff(random=true,
			delayExpression ="${retry.backoff.delay:100}",
			maxDelayExpression = "${retry.backoff.maxdelay:30000}"))
	public void retryConfig() throws Exception {
		
		LOGGER.debug("** RETRAYABLE CONFIGURED ***");
		
		throw new Exception("Retry Exception");
		
	}
	
	@Recover
	public void recover(Exception e, String msg) {
		LOGGER.debug("** RECOVERY METHOD ***");
		
	}
	
}
