package org.starter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class SecondAutoConfiguration {

    public SecondAutoConfiguration() {
        System.out.println("SecondAutoConfiguration");
    }

    @Bean
    public Demo demo() {
        System.out.println("demo");
        return new Demo();
    }

}
