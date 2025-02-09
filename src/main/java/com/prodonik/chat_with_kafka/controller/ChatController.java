package com.prodonik.chat_with_kafka.controller;

import com.prodonik.chat_with_kafka.model.ChatMessage;
import com.prodonik.chat_with_kafka.service.KafkaProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;

@Component
public class ChatController extends TextWebSocketHandler {

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ChatController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        ChatMessage chatMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);
        kafkaProducer.sendMessage(chatMessage);
    }
}
