package com.jean.analyzer;

import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.analyzers.weather.ConstantsAnalyzer.DEEP_LEVEL;
import com.jean.entity.BaitProperties;

public class BaitPropertiesAnalyzerTest extends BaseTest {

    private double cloudLevel;
    private double rainLevel;
    private String deepLevel;
    private List<BaitProperties> props;

    @Before
    public void init() {
	cloudLevel = 27;
	rainLevel = 82;
	deepLevel = DEEP_LEVEL.MIDDLE.toString();
    }
    
    @Test
    public void getTheBestColorTest() throws CustomDfmException{
	props = baitPropAnalyzer.getTheBestColor(cloudLevel, rainLevel, deepLevel);
	assertTrue(!props.isEmpty());
    }
}
