package com.jean.config;


import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;



/**
 * Created by stas on 30.05.15.
 */
@Configuration
@Profile("test")
@ComponentScan("com.jean.*")
public class TestConfiguration {


    /*@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/

//@Bean
//public BasicDataSource getBasicDataSource(){
//    BasicDataSource basicDataSource = new BasicDataSource();
//    basicDataSource.setDriverClassName(env.getProperty("mysql.driver"));
//    basicDataSource.setUrl(env.getProperty("mysql.url"));
//    basicDataSource.setEmail(env.getProperty("mysql.username"));
//    basicDataSource.setPassword(env.getProperty("mysql.password"));
//    basicDataSource.setInitialSize(10);
//    return basicDataSource;
//}
//
//    @Bean
//    public PoolConnectionFactory getConnectionFactory(){
//        return new PoolConnectionFactory();
//    }
}
