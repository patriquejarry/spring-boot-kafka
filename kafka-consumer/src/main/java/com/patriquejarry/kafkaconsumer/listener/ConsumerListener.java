package com.patriquejarry.kafkaconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.patriquejarry.kafkaconsumer.config.KafkaConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ConsumerListener {

	@KafkaListener(topics = KafkaConfig.DEFAULT_TOPIC, groupId = KafkaConfig.DEFAULT_GROUP)
	public void consumer(final String message) {

		log.info("Thread: {} : Message received => {}", Thread.currentThread().getId(), message);
	}
}
