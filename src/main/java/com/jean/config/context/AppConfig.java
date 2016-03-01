package com.jean.config.context;


import com.jean.config.PoolConnectionFactory;
import com.jean.config.property.DataBaseProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;


/**
 * Created by stas on 30.05.15.
 */
@Configuration
@EnableScheduling
@ComponentScan("com.jean.*")
@PropertySource("classpath:application.properties")
//@Import({SecurityConfig.class, SocialContext.class})
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private DataBaseProperties dataBaseProperties;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource getBasicDataSource(){
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
