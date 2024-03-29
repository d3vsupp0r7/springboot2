package org.lba.springboot2.kafka.xml.serializer;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

public class JAXBDeserializerConfig extends AbstractConfig {

	  public final Class<?> deserializedClass;

	  public static final String DESERIALIZED_CLASS_CONF = "deserialized.class";
	  static final String DESERIALIZED_CLASS_DOC = "";

	  public JAXBDeserializerConfig(Map<String, ?> originals) {
	    super(config(), originals);
	    this.deserializedClass = getClass(DESERIALIZED_CLASS_CONF);
	  }

	  public static ConfigDef config() {
	    return new ConfigDef()
	        .define(DESERIALIZED_CLASS_CONF, ConfigDef.Type.CLASS, ConfigDef.Importance.LOW, DESERIALIZED_CLASS_DOC);
	  }

}
