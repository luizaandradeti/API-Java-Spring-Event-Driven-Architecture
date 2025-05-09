package com.spring_kafka_docker.spring.resources;

import com.spring_kafka_docker.spring.services.ServiceProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/msgs")
@RequiredArgsConstructor
public class ProducerController {
    private final ServiceProducer kafkaProducerService;
    @PostMapping
    public String sendMessage(@RequestParam String key,
                              @RequestBody String message) {
        log.debug("Envio com keys: {}",
                key);
        kafkaProducerService.sendMessage(key,message.getBytes());
        return "Texto enviado:" + key;
    }
}