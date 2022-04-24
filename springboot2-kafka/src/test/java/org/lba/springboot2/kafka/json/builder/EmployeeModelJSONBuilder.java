package org.lba.springboot2.kafka.json.builder;

import java.security.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.springboot2.kafka.model.json.EmployeeJSONModel;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uk.co.jemos.podam.api.AttributeMetadata;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.PodamUtils;
import uk.co.jemos.podam.typeManufacturers.IntTypeManufacturerImpl;
import uk.co.jemos.podam.typeManufacturers.TypeManufacturer;

@RunWith(SpringRunner.class)
public class EmployeeModelJSONBuilder {

	@Test
	public void createEmployeeModelJSON() {
	
		/**/
		PodamFactory podamFactory = new PodamFactoryImpl();
		TypeManufacturer<Integer> manufacturer = new IntTypeManufacturerImpl() {
			
			public Integer getInteger(AttributeMetadata attributeMetadata) {
				if(attributeMetadata.getPojoClass() == Timestamp.class) {
					return PodamUtils.getIntegerInRange(0, 999999999);
				}else {
					return super.getInteger(attributeMetadata);
				}
				
			}
		};
		podamFactory.getStrategy().addOrReplaceTypeManufacturer(int.class, manufacturer);
		/**/
		EmployeeJSONModel model = podamFactory.manufacturePojo(EmployeeJSONModel.class);
		podamFactory.populatePojo(model);
		System.out.println("Podam Out: " + model.toString());
		/**/
		 Gson gson = new GsonBuilder().setPrettyPrinting()
				 .setDateFormat("dd-MM-yyyy HH:mm:ss")
				 .create();
		/**/
		 String jsonInstring = gson.toJson(model);
		 System.out.println("JSON Out: " + jsonInstring);
	}
}
