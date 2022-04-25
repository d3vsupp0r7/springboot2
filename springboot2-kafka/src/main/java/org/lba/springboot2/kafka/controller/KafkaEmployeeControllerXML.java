package org.lba.springboot2.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.lba.springboot2.kafka.model.json.EmployeeJSONModel;
import org.lba.springboot2.kafka.model.xml.EmployeeXMLModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping ("/api/kafka/xml/employee")
@Controller
public class KafkaEmployeeControllerXML {
	
	final KafkaTemplate kafkaTemplateXML;


    Logger logger = LoggerFactory.getLogger(KafkaEmployeeControllerXML.class);

    public KafkaEmployeeControllerXML(KafkaTemplate kafkaTemplateXML) {
        this.kafkaTemplateXML = kafkaTemplateXML;
    }

    @PostMapping
    public String sentMessage(@RequestBody EmployeeXMLModel employee) {
        this.kafkaTemplateXML.send("employee-xml-topic", 
        		new EmployeeXMLModel(
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

    @KafkaListener(topics = "employee-xml-topic")
    public void listener(@Payload EmployeeXMLModel employee,  ConsumerRecord<String, EmployeeXMLModel> cr) {
        logger.info("Topic [employee-xml-topic] Received message from {} with {} PLN ",
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
