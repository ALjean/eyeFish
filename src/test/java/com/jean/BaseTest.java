package com.jean;

import com.jean.analyzers.behavior.BehaviorAnalyzer;
import com.jean.config.context.AppConfig;
import com.jean.config.property.DataBaseProperties;
import com.jean.config.property.MessagesProperties;
import com.jean.dao.*;
import com.jean.service.UserService;
import com.jean.service.WeatherService;
import com.jean.util.RedisCacheStore;
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
// @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
// //create context after each method
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class BaseTest {

/*	@Autowired
	protected FishDao fishDao;

	@Autowired
	protected UserDao userDao;

	@Autowired
	protected BaitDao baitDao;*/
	
	@Autowired
	protected BehaviorAnalyzer behaviorAnalyzer;

	@Autowired
	protected WeatherService weatherService;

	@Autowired
	protected UserService userService;

	@Autowired
	protected RedisCacheStore redisStore;

	@Autowired
	protected DataBaseProperties dataBaseProperties;
	
	@Autowired
	protected MessagesProperties messagesProperties;
}
