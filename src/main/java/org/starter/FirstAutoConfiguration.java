package org.starter;


import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@AutoConfiguration
@AutoConfigureBefore(KafkaAutoConfiguration.class)
public class FirstAutoConfiguration {

    public FirstAutoConfiguration() {
        System.out.println("FirstAutoConfiguration");
    }

}
