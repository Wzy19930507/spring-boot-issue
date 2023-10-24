package org.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class TestConfiguration {

    public TestConfiguration(KafkaTemplate<String, String> kafkaTemplate) {
        kafkaTemplate.send("two", "send");
    }

}
