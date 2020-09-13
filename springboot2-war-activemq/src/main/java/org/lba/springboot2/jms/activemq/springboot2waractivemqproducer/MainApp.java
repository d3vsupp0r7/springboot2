package org.lba.springboot2.jms.activemq.springboot2waractivemqproducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainApp {

	public static void main(String[] args) {

		Product iphone7 = new Product("Iphone 7");
		Product iPadPro = new Product("IPadPro");

		List<Product> appleProducts = new ArrayList<Product>(Arrays.asList(iphone7, iPadPro));

		Company apple = new Company("Apple", appleProducts);

		iphone7.setCompany(apple);
		iPadPro.setCompany(apple);


		// Creating Object of ObjectMapper define in Jakson Api 
		ObjectMapper Obj = new ObjectMapper(); 

		try { 

			// get Oraganisation object as a json string 
			String jsonStr = Obj.writeValueAsString(apple); 

			// Displaying JSON String 
			System.out.println(jsonStr); 
		} 

		catch (IOException e) { 
			e.printStackTrace(); 
		} 

	}

}
