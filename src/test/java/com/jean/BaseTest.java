package com.jean;


import com.jean.config.AppConfiguration;
import com.jean.dao.FishDao;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Created by stas on 30.05.15.
 */

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =AppConfiguration.class, loader=AnnotationConfigContextLoader.class)
@ActiveProfiles("test")
public class BaseTest  {

    @Autowired
    protected FishDao fishDao;


}
