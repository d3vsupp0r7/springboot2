package org.lba.springboot2.jms.activemq.springboot2waractivemqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/obj")
public class MessageObjectController {

	@Autowired
	JmsProducer producer;

	@PostMapping("/message")
	public ResponseEntity<String> publish(@RequestBody Company company){
		producer.send(company);
		String message = "Message sent to activemq queue";
		return new ResponseEntity(message , HttpStatus.OK);
	}
}
