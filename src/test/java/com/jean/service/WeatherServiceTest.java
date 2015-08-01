package com.jean.service;

import com.jean.BaseTest;

import org.junit.Test;

/**
 * Created by root on 01.08.15.
 */
public class WeatherServiceTest extends BaseTest {


    @Test
    public void getWeatherDataTest(){
        String weatherData = weatherService.getWeatherData();
        System.out.println(weatherData);
    }
}
