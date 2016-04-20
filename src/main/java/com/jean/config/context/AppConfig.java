package com.jean.config.context;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jean.config.PoolConnectionFactory;
import com.jean.config.property.DataBaseProperties;
import com.jean.config.property.SqlScriptsProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by stas on 30.05.15.
 */
@Configuration
@EnableScheduling
//@EnableWebMvc
@ComponentScan({"com.jean.*", "com.jean.servlet.controller.*"})
@PropertySource("classpath:application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private SqlScriptsProperties sqlScriptsProperties;

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

//    @Bean
//    public DataSourceInitializer dataSourceInitializer() {
//        DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(getBasicDataSource());
//        initializer.setDatabasePopulator(databasePopulatorInit());
//        initializer.setDatabaseCleaner(databasePopulatorCleaner());
//        return initializer;
//    }
//
//    private DatabasePopulator databasePopulatorInit() {
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//        resourceDatabasePopulator.addScript(sqlScriptsProperties.getSchemaScript());
//        resourceDatabasePopulator.addScript(sqlScriptsProperties.getDataScript());
//        return resourceDatabasePopulator;
//    }
//
//    private DatabasePopulator databasePopulatorCleaner() {
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//        resourceDatabasePopulator.addScript(sqlScriptsProperties.getCleanerScript());
//        return resourceDatabasePopulator;
//    }

    @Bean
    public PoolConnectionFactory getConnectionFactory(){
        return new PoolConnectionFactory();
    }

}
