package org.lba.springboot2.kafka.consumer;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.lba.springboot2.kafka.model.xml.EmployeeXMLModel;
import org.lba.springboot2.kafka.xml.serializer.JAXBDeserializer;
import org.lba.springboot2.kafka.xml.serializer.JAXBDeserializerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class ConsumerXML {
	
	@Autowired
	private KafkaProperties kafkaProperties;

    public ConsumerXML(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }
    
    /**/
	@Bean
	public ConsumerFactory<String, Object> byteArrayEmployeeConsumerFactory() {
		JAXBDeserializer<Object> deser = new JAXBDeserializer<Object>();
		Map<String, Object> settings = new LinkedHashMap<>();
		settings.put(JAXBDeserializerConfig.DESERIALIZED_CLASS_CONF, EmployeeXMLModel.class.getName());
		deser.configure(settings,false);
		return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(), new StringDeserializer(), deser);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,Object> kafkaListenerEmployeeXMLByteArrayContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(byteArrayEmployeeConsumerFactory());
		return factory;
	}
  

}
