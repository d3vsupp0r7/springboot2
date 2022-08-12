package org.lba.springboot2.kafka.xml.serializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.serialization.Deserializer;

public class JAXBDeserializer<T> extends BaseJAXB implements Deserializer<T> {

	JAXBDeserializerConfig config;

	@Override
	public void configure(Map<String, ?> map, boolean b) {
		this.config = new JAXBDeserializerConfig(map);
	}

	@Override
	public T deserialize(String s, byte[] bytes) {
		if (null == bytes) {
			return null;
		}

		try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes)) {
			Unmarshaller unmarshaller = createUnmarshaller(this.config.deserializedClass);
			return (T) unmarshaller.unmarshal(inputStream);
		} catch (IOException | JAXBException ex) {
			throw new KafkaException("Exception thrown while deserializing value", ex);
		}
	}


	@Override
	public void close() {

	}
}
