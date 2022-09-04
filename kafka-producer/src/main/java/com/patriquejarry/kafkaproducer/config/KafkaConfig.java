package com.patriquejarry.kafkaproducer.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

	public static final String DEFAULT_TOPIC = "topic-1";

	@Autowired
	private KafkaProperties kafkaProperties;

	// Standard implementation of producer application - START
	// ************************************************************************************************
	@Bean
	public ProducerFactory<String, String> producerFactory() {

		final var configs = new HashMap<String, Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return new DefaultKafkaProducerFactory<>(configs);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	// ************************************************************************************************
	// Standard implementation of producer application - END

	// Standard to create a topic from the application - START
	// ************************************************************************************************
	// Not necessary if topic is create outside application,
	// like by the infra team on the container !
	//
	@Bean
	public KafkaAdmin kafkaAdmin() {
		final var configs = new HashMap<String, Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		return new KafkaAdmin(configs);
	}

	@Bean
	public NewTopic topic1() {
		return new NewTopic(KafkaConfig.DEFAULT_TOPIC, 10, Short.valueOf("1"));
	}

	// ************************************************************************************************
	// Standard to create a topic from the application - END

}
