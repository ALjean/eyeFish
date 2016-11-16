package com.jean.util;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.redis.Coordinates;
import com.jean.entity.weather.GeneralDayWeather;
import com.jean.entity.weather.GeneralHourWeather;
import com.jean.enums.RedisKeys;

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
        generalDayWeather.setCoordLat(40.7143528f);
        generalDayWeather.setCoordLon(74.0059731f);

        generalHourWeather = new GeneralHourWeather();
        generalHourWeather.setCityName("Test city");
        generalHourWeather.setCountry("USA");
        generalHourWeather.setCoordLat(40.7143528f);
        generalHourWeather.setCoordLon(74.0059731f);

        coordinates = new Coordinates(RedisKeys.HourWeather, 74.0059731f, 40.7143528f);

        wrongCoordinates = new Coordinates(RedisKeys.HourWeather, 90.0059731f, 35.7143528f);
    }


//    @Test
//    public void storeDayWeatherTest(){
//        redisStore.setDayWeather(generalDayWeather);
//        assertNotNull(redisStore.findDayWeather(coordinates));
//        assertNull(redisStore.findDayWeather(wrongCoordinates));
//    }
//
//    @Test
//    public void storeHourWeatherTest() {
//        redisStore.setHourWeather(generalHourWeather);
//        assertNotNull(redisStore.findHourWeather(coordinates));
//        assertNull(redisStore.findHourWeather(wrongCoordinates));
//
//    }

    @Test
    public void setGeneralHourWeatherTest() throws CustomDfmException {
        redisStore.setWeather(generalHourWeather);
/*        assertNotNull(redisStore.findHourWeather(coordinates));
        assertNull(redisStore.findHourWeather(wrongCoordinates));*/
    }



}
