package com.jean;


import com.jean.config.context.AppConfig;
import com.jean.config.property.DataBaseProperties;
import com.jean.dao.*;
import com.jean.schedule.DataWeatherDataBaseWriter;
import com.jean.service.FishAnalyzerService;
import com.jean.service.UserService;
import com.jean.service.WeatherService;
import com.jean.analyzers.fish.FishAnalyzer;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Stas on 30.05.15.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ActiveProfiles("test")
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) //create context after each method
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class BaseTest {

    @Autowired
    protected FishDao fishDao;

    @Autowired
    protected WeatherDao weatherDao;

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected BaitDao baitDao;

    @Autowired
    protected WeatherService weatherService;

    @Autowired
    protected FishAnalyzerService fishAnalyzerService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected DataWeatherDataBaseWriter dataWeatherDataBaseWriter;

    @Autowired
    protected FishAnalyzer fishAnalyzer;
    
    @Autowired
    protected DataBaseProperties dataBaseProperties;
}
