package com.kodiatech.kafka.controller;

import com.kodiatech.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class KafkaController {
    private final KafkaProducerService producerService;
    @Autowired
    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
        producerService.sendMessage("my-topic", message);
        return ResponseEntity.ok("Message published to Kafka topic");
    }

//

   // POST http://localhost:8080/publish?message=HelloKafka
}
