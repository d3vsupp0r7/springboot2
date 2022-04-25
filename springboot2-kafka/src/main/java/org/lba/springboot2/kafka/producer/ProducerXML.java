package org.lba.springboot2.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.lba.springboot2.kafka.xml.serializer.JAXBSerializer;
import org.lba.springboot2.kafka.xml.serializer.JAXBSerializerConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProducerXML {

    final KafkaProperties kafkaProperties;

    public ProducerXML(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }


    @Bean
    public Map<String, Object> producerConfigurationXML() {
        Map<String, Object> properties = new HashMap<>(kafkaProperties.buildProducerProperties());
        properties.put(JAXBSerializerConfig.JAXB_FORMATTED_OUTPUT_CONF, "true");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JAXBSerializer.class);
        return properties;
    }

    @Bean
    ProducerFactory<String, Object> producerFactoryXML() {
        return new DefaultKafkaProducerFactory<>(producerConfigurationXML());
    }

    @Bean
    KafkaTemplate<String, Object> kafkaTemplateXML() {
        return new KafkaTemplate<>(producerFactoryXML());
    }

    @Bean
    public NewTopic topicXML() {
        return new NewTopic("employee-xml-topic", 2, (short) 1);
    }
}
