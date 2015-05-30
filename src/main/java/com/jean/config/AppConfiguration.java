package com.jean.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by stas on 30.05.15.
 */
@Configuration
@ComponentScan("com.jean.*")
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(driverManagerDataSource());
        return template;
    }

    @Bean
    public DataSource driverManagerDataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName(env.getProperty("mysql.driver"));
        driver.setUrl(env.getProperty("mysql.url"));
        driver.setUsername(env.getProperty("mysql.username"));
        driver.setPassword(env.getProperty("mysql.password"));
        return driver;
    }


}
