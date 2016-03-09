package com.jean.config.context;


import com.jean.config.PoolConnectionFactory;
import com.jean.config.property.DataBaseProperties;
import com.jean.config.property.SqlScriptsProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
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
