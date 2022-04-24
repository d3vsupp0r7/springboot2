package org.lba.springboot2.kafka.model.xml.adapters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyTimestampXMLParserAdapter  extends XmlAdapter<String, Timestamp>  {

	 private static final String CUSTOM_FORMAT_STRING = "dd-MM-yyyy HH:mm:ss";

	    @Override
	    public String marshal(Timestamp v) {
	        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(v);
	    }

	    @Override
	    public Timestamp unmarshal(String dateTime) throws ParseException {
	    	DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern(CUSTOM_FORMAT_STRING);
	        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dateTime));
	        Timestamp ts = Timestamp.valueOf(localDateTime);
	        return ts;
	    }
}
