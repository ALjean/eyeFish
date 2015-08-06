package com.jean.service;

import com.jean.BaseTest;

import com.jean.model.owm.GeneralWeatherStateOWM;
import org.junit.Test;

/**
 * Created by root on 01.08.15.
 */
public class WeatherServiceTest extends BaseTest {


    @Test
    public void getHoursWeatherStateTest(){
        GeneralWeatherStateOWM generalWeatherStateOWM = weatherService.getHoursWeatherState();
        System.out.println(generalWeatherStateOWM);
    }

    @Test
    public void getDayWeatherStateTest(){
        GeneralWeatherStateOWM generalWeatherStateOWM = weatherService.getDayWeatherState();
        System.out.println(generalWeatherStateOWM);
    }


}
