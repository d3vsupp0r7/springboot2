package org.lba.springboot2.util;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtil {
	
	static final Logger logger = Logger.getLogger(JsonUtil.class); 

	public static String getJsonFormat(Object anObject) {
		
		String result = null;
		
		try {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(anObject);
			logger.debug("Form as json: " + json);
			result = json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
