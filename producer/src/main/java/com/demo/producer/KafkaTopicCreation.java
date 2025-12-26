package com.demo.producer;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicCreation {

    @Bean
    public NewTopic createNewTopic() {
        return new NewTopic("my-topic-class", 3, (short) 1);
    }

    @Bean
    public NewTopic createTopicTest() {
        return new NewTopic("my-topic-test", 3, (short) 1);
    }
}
