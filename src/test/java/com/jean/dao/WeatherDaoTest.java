package com.jean.dao;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.Weather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by stas on 18.07.15.
 */
public class WeatherDaoTest extends BaseTest {

    private Weather weather;

    private int id;

    private Date date;

    @Before
    public void init() throws ParseException {
        String testDate = "13/01/2016";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = formatter.parse(testDate);

        weather = new Weather();
        weather.setDate(new Date());
        weather.setCity("Kharkov");
        weather.setTempDay(21.5f);
        weather.setTempEven(19.1f);
        weather.setTempMorn(23.2f);
        weather.setTempNight(24.2f);
        weather.setPressure(1003);
        weather.setWindSpeed(4);
        weather.setWindDeg(130);
        weather.setHumidity(2);
        weather.setClouds(75);
    }

    @Test
    @Ignore
    public void saveTest() throws CustomDfmException {
        weatherDao.save(weather);
        System.out.println("Test weather save");
    }

    @Test
    public void getLimitWeatherByDateTest() throws CustomDfmException {
        List<Weather> weathers = weatherDao.getLimitWeatherByDate(date);
        Assert.assertTrue(weathers.size() > 0);

    }

    @Test
    public void getAllWeatherTest() throws CustomDfmException {
        List<Weather> weathers = weatherDao.getAllWeather();
        Assert.assertTrue(weathers.size() > 0);
    }

}
