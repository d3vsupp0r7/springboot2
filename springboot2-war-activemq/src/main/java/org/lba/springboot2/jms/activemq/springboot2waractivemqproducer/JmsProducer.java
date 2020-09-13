package org.lba.springboot2.jms.activemq.springboot2waractivemqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class JmsProducer {
	@Autowired
	JmsTemplate jmsTemplate;

	@Value("${activemq.object.queue}")
	String queue;

	public void send(Company company){
		jmsTemplate.convertAndSend(queue, company);
	}
}
