package org.lba.springboot2.kafka.xml.builder;

import java.io.StringWriter;
import java.security.Timestamp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.springboot2.kafka.model.xml.EmployeeXMLModel;
import org.springframework.test.context.junit4.SpringRunner;

import uk.co.jemos.podam.api.AttributeMetadata;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.PodamUtils;
import uk.co.jemos.podam.typeManufacturers.IntTypeManufacturerImpl;
import uk.co.jemos.podam.typeManufacturers.TypeManufacturer;

@RunWith(SpringRunner.class)
public class EmployeeModelXMLBuilder {

	@Test
	public void createEmployeeModelXML() {

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
		EmployeeXMLModel model = podamFactory.manufacturePojo(EmployeeXMLModel.class);
		podamFactory.populatePojo(model);
		System.out.println("XML Podam Out: " + model.toString());
		/**/
		//Method which uses JAXB to convert object to XML
		jaxbObjectToXML(model);

	}

	private static void jaxbObjectToXML(EmployeeXMLModel employee) 
	{
		try
		{
			//Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeXMLModel.class);

			//Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			//Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			//Print XML String to Console
			StringWriter sw = new StringWriter();

			//Write XML to StringWriter
			jaxbMarshaller.marshal(employee, sw);

			//Verify XML Content
			String xmlContent = sw.toString();
			System.out.println( xmlContent );

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
