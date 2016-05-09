//package com.jean.config;
//
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jean.config.property.DataBaseProperties;
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.*;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//
///**
// * Created by stas on 30.05.15.
// */
//@Configuration
//@ComponentScan(basePackages = { "com.jean.*" }, excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
//public class TestConfiguration extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    private DataBaseProperties dataBaseProperties;
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Bean
//    public DataSource getBasicDataSource(){
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setDriverClassName(dataBaseProperties.getDriver());
//        basicDataSource.setUrl(dataBaseProperties.getUrl());
//        basicDataSource.setUsername(dataBaseProperties.getUserName());
//        basicDataSource.setPassword(dataBaseProperties.getPassword());
//        basicDataSource.setInitialSize(dataBaseProperties.getPool());
//        return basicDataSource;
//    }
//
//
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
//        return converter;
//    }
//
//    @Bean
//    public PoolConnectionFactory getConnectionFactory(){
//        return new PoolConnectionFactory();
//    }
//
//}
