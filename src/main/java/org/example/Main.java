package org.example;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate kafkaTemplate) {
        // 是否同步
        return args -> {
            while (true) {
                Thread.sleep(1000);
                kafkaTemplate.send("ok", "1");
            }
        };
    }

}