package com.jean.schedule;

import com.jean.BaseTest;
import com.jean.CustomDfmException;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Stas on 08.08.15.
 */
public class DataWeatherDataBaseWriterTest extends BaseTest {

    @Test
    @Ignore
    public void parseOwnWeatherTest() throws CustomDfmException {
        dataWeatherDataBaseWriter.parseOwnWeather();
        System.out.println("Test Writer API");
    }

}
