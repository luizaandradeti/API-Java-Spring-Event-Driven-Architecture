package com.spring_kafka_docker.spring.services;

public interface ServiceProducer {
    void sendMessage(String key,byte[] message);
}