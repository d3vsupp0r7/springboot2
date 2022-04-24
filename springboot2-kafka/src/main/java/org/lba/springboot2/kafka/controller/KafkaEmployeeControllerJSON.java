package org.lba.springboot2.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.lba.springboot2.kafka.model.json.EmployeeJSONModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping ("/api/kafka/employee")
@RestController
public class KafkaEmployeeControllerJSON {
	
	final KafkaTemplate kafkaTemplate;


    Logger logger = LoggerFactory.getLogger(KafkaEmployeeControllerJSON.class);

    public KafkaEmployeeControllerJSON(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sentMessage(@RequestBody EmployeeJSONModel employee) {
        this.kafkaTemplate.send("employee-topic", 
        		new EmployeeJSONModel(
        			employee.getId(),
        			employee.getName(),
        			employee.getSurname(),
        			employee.getSalary(),
        			employee.getDateOfBorn(),
        			employee.getRegistrationDate()
        				)
        		);

        return "Hello World!";
    }

    @KafkaListener(topics = "employee-topic")
    public void listener(@Payload EmployeeJSONModel employee,  ConsumerRecord<String, EmployeeJSONModel> cr) {
        logger.info("Topic [employee-topic] Received message from {} with {} PLN ",
        		employee.getId(),
    			employee.getName(),
    			employee.getSurname(),
    			employee.getSalary(),
    			employee.getDateOfBorn(),
    			employee.getRegistrationDate()
        		);
        logger.info(cr.toString());
    }


}
