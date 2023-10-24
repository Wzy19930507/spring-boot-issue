package org.starter;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;

@AutoConfiguration
@EnableConfigurationProperties(KafkaProperties.class)
@AutoConfigureBefore({KafkaAutoConfiguration.class})
@ConditionalOnClass(KafkaTemplate.class)
@Order(Integer.MIN_VALUE)
public class KafkaPropertiesCustomizerAutoConfiguration {

    private final KafkaProperties kafkaProperties;

    public KafkaPropertiesCustomizerAutoConfiguration(
            KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @PostConstruct
    public void customKafkaProperties() {
        customKafkaProperties(kafkaProperties);
    }

    private void customKafkaProperties(KafkaProperties kafkaProperties) {
        customKafkaProducerProperties(kafkaProperties);
    }

    private void customKafkaProducerProperties(KafkaProperties kafkaProperties) {

    }

}