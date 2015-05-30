package com.jean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by stas on 30.05.15.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.jean")
public class AppConfiguration {

    @Bean
    public UrlBasedViewResolver setupBaseResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/pages/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);
        return urlBasedViewResolver;
    }
}
