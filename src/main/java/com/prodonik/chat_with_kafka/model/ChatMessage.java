package com.prodonik.chat_with_kafka.model;

public class ChatMessage {
    private String chatKey;
    private String sender;
    private String message;

    public ChatMessage() {}

    public ChatMessage(String chatKey, String sender, String message) {
        this.chatKey = chatKey;
        this.sender = sender;
        this.message = message;
    }

    public String getChatKey() { return chatKey; }
    public String getSender() { return sender; }
    public String getMessage() { return message; }
}
