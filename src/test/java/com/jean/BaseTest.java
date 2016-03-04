package com.jean;


import com.jean.config.context.AppConfig;
import com.jean.servlet.controller.AuthenticationController;
import com.jean.dao.BaitDao;
import com.jean.dao.FishDao;
import com.jean.dao.UserDao;
import com.jean.dao.WeatherDao;
import com.jean.schedule.DataWeatherDataBaseWriter;
import com.jean.service.CryptService;
import com.jean.service.FishAnalyzerService;
import com.jean.service.UserService;
import com.jean.service.WeatherService;
import com.jean.analyzers.fish.BaitPropertiesAnalyzer;
import com.jean.analyzers.fish.FishAnalyzer;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by Stas on 30.05.15.
 */

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader=AnnotationConfigContextLoader.class)
@ActiveProfiles("test")
public class BaseTest  {

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

    //@Autowired
    protected CryptService cryptService;

   // @Autowired
    protected UserService userService;

    @Autowired
    protected DataWeatherDataBaseWriter dataWeatherDataBaseWriter;
    
    @Autowired
    protected FishAnalyzer fishAnalyzer;
    
    @Autowired
    protected BaitPropertiesAnalyzer baitPropAnalyzer;

    //@Autowired
    protected AuthenticationController authenticationController;


}
