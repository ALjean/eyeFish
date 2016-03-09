package com.jean.dao;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.BaitProperties;
import com.jean.enums.BrightLevel;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertTrue;

public class BaitPropertiesDaoTest extends BaseTest {


    private List<BaitProperties> props;
    private double cloudLevel;
    private double temperature;

    @Before
    public void init() {
        cloudLevel = 23;
        temperature = 26;
    }

    @Test
    public void getBaitColorsByCloudLevelTest() throws CustomDfmException {
        props = baitPropertiesDao.getBaitColors(cloudLevel);
        assertTrue(!props.isEmpty());
    }

    @Test
    public void getBaitColorByNameTest() throws CustomDfmException {
        props = baitPropertiesDao.getBaitColors(BrightLevel.DARK);
        assertTrue(!props.isEmpty());
    }

    @Test
    public void getBaitTastesByTemperature() throws CustomDfmException {
        props = baitPropertiesDao.getBaitTastes(temperature);
        assertTrue(!props.isEmpty());
    }
}
