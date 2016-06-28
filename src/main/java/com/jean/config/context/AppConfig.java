package com.jean.config.context;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jean.config.property.DataBaseProperties;
import com.jean.config.property.RedisProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by stas on 30.05.15.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.jean.*"})
@PropertySource("classpath:properties/app.properties")
//@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private DataBaseProperties dataBaseProperties;

    @Autowired
    private RedisProperties redisProperties;

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
        basicDataSource.setInitialSize(dataBaseProperties.getPool());
        return basicDataSource;
    }


    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
        return converter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }

    @Bean
    public JedisPool jedisPool(){
        return new JedisPool(redisProperties.getHost(), redisProperties.getPort());
    }

}
