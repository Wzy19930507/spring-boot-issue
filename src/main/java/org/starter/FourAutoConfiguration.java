package org.starter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class FourAutoConfiguration {

    public FourAutoConfiguration() {
        System.out.println("FourAutoConfiguration");
    }

    @Bean
    public Demo2 demo2() {
        System.out.println("demo2");
        return new Demo2();
    }

}
