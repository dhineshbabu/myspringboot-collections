package com.performance.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean
    @Qualifier("bean1")
    @Profile("dev")
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First Performance Bean");
    }


    @Bean
    @Qualifier("bean2")
    @Profile("test")
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("Second Performance Bean");
    }

    @Bean
    @Primary
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("Third Performance Bean");
    }
}
