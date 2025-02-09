package com.prodonik.chat_with_kafka.service;

import com.prodonik.chat_with_kafka.model.ChatMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, ChatMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ChatMessage message) {
        kafkaTemplate.send(message.getChatKey(), message);
    }
}
