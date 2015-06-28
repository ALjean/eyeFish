package com.jean.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.sql.DataSource;


/**
 * Created by stas on 30.05.15.
 */
@Configuration
@Profile("test")
@ComponentScan("com.jean.*")
//@PropertySource("classpath:application.properties")
public class TestConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

@Bean
public BasicDataSource getBasicDataSource(){
    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName(env.getProperty("mysql.driver"));
    basicDataSource.setUrl(env.getProperty("mysql.url"));
    basicDataSource.setUsername(env.getProperty("mysql.username"));
    basicDataSource.setPassword(env.getProperty("mysql.password"));
    basicDataSource.setInitialSize(10);
    return basicDataSource;
}

    @Bean
    public PoolConnectionFactory getConnectionFactory(){
        return new PoolConnectionFactory();
    }
}
