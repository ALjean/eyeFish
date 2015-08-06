package com.jean.config;


import com.jean.config.property.DataBaseProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Created by stas on 30.05.15.
 */
@Configuration
@EnableScheduling
@ComponentScan("com.jean.*")
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    DataBaseProperties dataBaseProperties;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public BasicDataSource getBasicDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(dataBaseProperties.getDriver());
        basicDataSource.setUrl(dataBaseProperties.getUrl());
        basicDataSource.setUsername(dataBaseProperties.getUserName());
        basicDataSource.setPassword(dataBaseProperties.getPassword());
        basicDataSource.setInitialSize(10); //todo check prop
        return basicDataSource;
    }

    @Bean
    public PoolConnectionFactory getConnectionFactory(){
        return new PoolConnectionFactory();
    }


}
