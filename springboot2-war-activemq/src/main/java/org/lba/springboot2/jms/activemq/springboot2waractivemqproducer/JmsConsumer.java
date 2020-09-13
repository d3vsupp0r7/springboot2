package org.lba.springboot2.jms.activemq.springboot2waractivemqproducer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

	@JmsListener(destination = "${activemq.object.queue}", containerFactory="jsaFactory")
	public void receive(Company company){
		System.out.println("Recieved Message: " + company);
	}
}
