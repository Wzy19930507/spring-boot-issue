package org.starter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;

@AutoConfiguration
@AutoConfigureBefore(FourAutoConfiguration.class)
public class ThirdAutoConfiguration {

    public ThirdAutoConfiguration() {
        System.out.println("ThirdAutoConfiguration");
    }

}
