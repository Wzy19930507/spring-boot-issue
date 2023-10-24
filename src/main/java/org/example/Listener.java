package org.example;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@KafkaListener(id = "multi-param2", topics = { "TEST" })
public class Listener {

    @KafkaHandler
    public void foo(Integer bar, List<String> foo) {
        System.out.printf("Received foo: %s, bar %s \n", foo, bar);
    }

    @KafkaHandler
    public void foo(Long bar, Short foo) {
        System.out.printf("Received foo: %s, bar %s \n", foo, bar);
    }

}
