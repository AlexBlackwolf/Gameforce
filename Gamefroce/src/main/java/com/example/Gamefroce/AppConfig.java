package com.example.Gamefroce;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

@Configuration
@ComponentScan("com.example.Gamefroce.repository")
@EntityScan("com.example.Gamefroce.entity")
public class AppConfig {
    @Bean
    public String getStringBean() {
        return "Hello, World!";
    }
    @Bean
    public Long getLongBean() {
        return Long.valueOf(0L);
    }
    @Bean
    public Integer getIntegerBean() {
        return Integer.valueOf(10);
    }
    @Bean
    public Double getDoubleBean() {
        return Double.valueOf(0.0);
    }
    @Bean
    public Timestamp getTimestampBean() {
        return new Timestamp(System.currentTimeMillis());
    }
}
