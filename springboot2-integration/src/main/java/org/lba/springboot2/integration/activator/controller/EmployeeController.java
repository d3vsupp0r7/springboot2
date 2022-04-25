package org.lba.springboot2.integration.activator.controller;

import org.lba.springboot2.integration.model.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping ("/api/integration/employee")
public class EmployeeController {

	@Autowired
	private MessageChannel producerChannel;
	@Autowired
	private MessageChannel errorChannel;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public void produceMessage(@RequestBody EmployeeData employeeDataToSend) {
		
		/**/

		/**/
		MessageBuilder<EmployeeData> siMsgBuilder = MessageBuilder.withPayload(employeeDataToSend);
		Message<EmployeeData> siMessgae = siMsgBuilder.build();
		/**/
		producerChannel.send(siMessgae);
		
	}
}
