package com.spring_kafka_docker.spring.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl {
    private static final String TOPIC = "topic";

    @KafkaListener(topics = TOPIC, groupId = "kafka-group")
    public void consume(ConsumerRecord<String, byte[]> record) {
        String key = record.key();
        byte[] value = record.value();
        System.out.println("Mensagem recebida: Key = " + key + ", Value = " + new String(value));
        }
}