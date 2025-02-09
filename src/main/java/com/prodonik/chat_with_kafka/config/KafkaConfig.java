package com.prodonik.chat_with_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createDefaultTopic() {
        return TopicBuilder.name("default-chat").partitions(1).replicas(1).build();
    }
}
