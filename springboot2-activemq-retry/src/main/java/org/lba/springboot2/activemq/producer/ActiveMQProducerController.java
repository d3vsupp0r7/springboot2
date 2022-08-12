package org.lba.springboot2.activemq.producer;

import javax.jms.Queue;

import org.lba.springboot2.activemq.db.model.EmployeeDBModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/produce")
public class ActiveMQProducerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMQProducerController.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue;

	@PostMapping("/message")
	public EmployeeDBModel sendMessage(@RequestBody EmployeeDBModel student) {

		LOGGER.debug("** produce message ***");
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String studentAsJson = mapper.writeValueAsString(student);

			jmsTemplate.convertAndSend(queue, studentAsJson);
		} catch (Exception e) {
			LOGGER.debug("** EXCEPTION: produce message ***");
			e.printStackTrace();
		}
		return student;
	}
	
}
