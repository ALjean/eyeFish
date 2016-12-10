package com.jean.config.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by jean on 10.12.16.
 */
@Configuration
@Profile("development")
@PropertySource("classpath:properties/app-development.properties")
public class DevelopmentConfig {
}
