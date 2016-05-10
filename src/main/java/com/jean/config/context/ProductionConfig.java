package com.jean.config.context;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("production")
@PropertySource("classpath:properties/app-production.properties")
public class ProductionConfig {
}
