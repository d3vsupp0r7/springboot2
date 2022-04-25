package org.lba.springboot2.kafka.xml.serializer;


import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.serialization.Serializer;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public class JAXBSerializer extends BaseJAXB implements Serializer<Object> {
	  JAXBSerializerConfig config;

	  @Override
	  public void configure(Map<String, ?> map, boolean b) {
	    this.config = new JAXBSerializerConfig(map);
	  }

	  @Override
	  public byte[] serialize(String topic, Object value) {
	    if (null == value) {
	      return null;
	    }

	    Marshaller marshaller = createMarshaller(value.getClass(), this.config);
	    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
	      marshaller.marshal(value, outputStream);
	      return outputStream.toByteArray();
	    } catch (IOException | JAXBException ex) {
	      throw new KafkaException("Exception thrown while serializing value", ex);
	    }
	  }

	  @Override
	  public void close() {

	  }
	  
}
