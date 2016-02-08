package com.jean.config;

import com.jean.AuthenticationTokenProcessingFilter;
import com.jean.config.property.CryptProperties;
import com.jean.config.property.DataBaseProperties;
import com.jean.config.security.SocialContext;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private DataBaseProperties dataBaseProperties;

    @Autowired
    CryptProperties cryptProperties;

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
    public AuthenticationTokenProcessingFilter authenticationTokenProcessingFilter(){
        return new AuthenticationTokenProcessingFilter();
    }

    @Bean
    public PoolConnectionFactory getConnectionFactory(){
        return new PoolConnectionFactory();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
}
