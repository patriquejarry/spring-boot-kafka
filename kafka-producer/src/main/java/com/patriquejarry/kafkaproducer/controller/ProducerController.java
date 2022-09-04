package com.patriquejarry.kafkaproducer.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.patriquejarry.kafkaproducer.config.KafkaConfig;

@RestController
public class ProducerController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("/producer/{message}")
	public ResponseEntity<?> producer(@PathVariable("message") final String message) {

		kafkaTemplate.send(KafkaConfig.DEFAULT_TOPIC, String.format("%s : %s", LocalDateTime.now(), message));

		return ResponseEntity.ok().build();
	}
}
