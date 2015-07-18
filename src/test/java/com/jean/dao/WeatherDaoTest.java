package com.jean.dao;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.Weather;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;


/**
 * Created by stas on 18.07.15.
 */
public class WeatherDaoTest extends BaseTest{

    /* private int id;
    private Date date;
    private float temperature;
    private float minTemperature;
    private float maxTemperature;
    private int pressure;
    private float windSpeed;
    private float windDeg;
    private int clouds; */

    private Weather weather;

    private int id;

    @Before
    public void init(){
        weather = new Weather();
        weather.setDate(new Date());
        weather.setCity("Kharkov");
        weather.setTemperature(21.5f);
        weather.setMinTemperature(19.1f);
        weather.setMaxTemperature(23.2f);
        weather.setPressure(1003);
        weather.setWindSpeed(4);
        weather.setWindDeg(130);
        weather.setClouds(75);
    }

    @Test
//    @Ignore
    public void createTest() throws CustomDfmException {
        weatherDao.create(weather);
        System.out.println("Test weather save");
    }

}
