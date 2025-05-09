package com.spring_kafka_docker.spring.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ServiceProducer {
    private static final String TOPIC = "topic";
    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    public void sendMessage(String key, byte[] message) {
        try
        {
            kafkaTemplate.send(TOPIC, key, message);
            log.info("Texto enviado para o topic:{} : {} ", TOPIC, key);
        }
        catch (Exception e){
            log.error("Erro : {}", String.valueOf(e));
        }}}