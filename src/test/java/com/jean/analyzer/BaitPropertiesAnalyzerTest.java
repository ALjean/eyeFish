package com.jean.analyzer;

import java.util.List;

import com.jean.DaoDfmException;
import org.junit.*;
import static org.junit.Assert.*;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.analyzers.weather.ConstantsAnalyzer.*;
import com.jean.entity.BaitPropertie;

public class BaitPropertiesAnalyzerTest extends BaseTest {

    private double cloudLevel;
    private double rainLevel;
    private String deepLevel;
    private List<BaitPropertie> props;

    @Before
    public void init() {
	cloudLevel = 15;
	rainLevel = 70;
	deepLevel = DEEP_LEVEL.SHALLOW.toString();
    }
    
   /* @Test
    public void getTheBestColorTest() throws CustomDfmException, DaoDfmException {
	props = baitPropAnalyzer.getTheBestColor(cloudLevel, rainLevel, deepLevel, null);
	assertTrue(!props.isEmpty());
	System.out.println(props.get(0).getName());
    }*/
}
