package com.jean.util;

import com.jean.BaseTest;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.servlet.model.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jean on 16.05.16.
 */
public class RedisCacheStoreTest extends BaseTest {


    private GeneralHourWeather generalHourWeather;
    private GeneralDayWeather generalDayWeather;
    private Coordinates coordinates;
    private Coordinates wrongCoordinates;

    @Before
    public void init() {
        generalDayWeather = new GeneralDayWeather();
        generalDayWeather.setCityName("Test city");
        generalDayWeather.setCountry("USA");
        generalDayWeather.setCoordLat(40.7143528);
        generalDayWeather.setCoordLon(74.0059731);

        generalHourWeather = new GeneralHourWeather();
        generalHourWeather.setCityName("Test city");
        generalHourWeather.setCountry("USA");
        generalHourWeather.setCoordLat(40.7143528);
        generalHourWeather.setCoordLon(74.0059731);

        coordinates = new Coordinates();
        coordinates.setLatitude(40.7143528);
        coordinates.setLongitude(74.0059731);

        wrongCoordinates = new Coordinates();
        wrongCoordinates.setLatitude(35.7143528);
        wrongCoordinates.setLongitude(90.0059731);
    }


    @Test
    public void storeDayWeatherTest(){
        redisStore.setDayWeather(generalDayWeather);
        assertNotNull(redisStore.findDayWeather(coordinates));
        assertNull(redisStore.findDayWeather(wrongCoordinates));


    }

    @Test
    public void storeHourWeatherTest() {
        redisStore.setHourWeather(generalHourWeather);
        assertNotNull(redisStore.findHourWeather(coordinates));
        assertNull(redisStore.findHourWeather(wrongCoordinates));

    }



}
