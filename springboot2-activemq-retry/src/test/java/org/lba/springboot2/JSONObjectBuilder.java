package org.lba.springboot2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.springboot2.activemq.db.model.EmployeeDBModel;
import org.lba.springboot2.activemq.producer.ActiveMQProducerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
public class JSONObjectBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONObjectBuilder.class);
	
	@Test
	public void generateJSON() {
		PodamFactory factory = new PodamFactoryImpl();
		EmployeeDBModel model = factory.manufacturePojo(EmployeeDBModel.class);
		/**/
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonAsString = gson.toJson(model);
		/**/
		LOGGER.debug("Output: \n" + jsonAsString);
		/**
		 
		 {
		    "id": 4944176491200,
		    "firstName": "OXv3gNZv1T",
		    "lastName": "dduYkA2s5D",
		    "code": "uxgvMJVTlE",
		    "dob": "12/08/2022"
		 }

		 */
	}

}
