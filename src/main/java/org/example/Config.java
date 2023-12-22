package org.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.ContainerCustomizer;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.BatchListenerFailedException;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.DefaultErrorHandler;

import java.util.List;

@Configuration
public class Config {

    private final KafkaProperties properties;

    Config(KafkaProperties properties) {
        this.properties = properties;
    }

    @KafkaListener(id = "multiGroup", topics = { "TEST" })
    public void foo(List<String> foo) {
        System.out.println("Received: " + foo);
        throw new BatchListenerFailedException("Infinite loop", foo.size() - 1);
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ObjectProvider<ConsumerFactory<Object, Object>> kafkaConsumerFactory,
            ObjectProvider<ContainerCustomizer<Object, Object, ConcurrentMessageListenerContainer<Object, Object>>> kafkaContainerCustomizer,
            ObjectProvider<SslBundles> sslBundles) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, kafkaConsumerFactory.getIfAvailable(() -> new DefaultKafkaConsumerFactory<>(
                this.properties.buildConsumerProperties(sslBundles.getIfAvailable()))));
        kafkaContainerCustomizer.ifAvailable(factory::setContainerCustomizer);
        DefaultErrorHandler eh = new DefaultErrorHandler();
        eh.setSeekAfterError(false);
        factory.setBatchListener(true);
        factory.setCommonErrorHandler(eh);
        return factory;
    }

}
