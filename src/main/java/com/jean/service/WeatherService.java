package com.jean.service;


import com.jean.servlet.model.owm.current.CurrentWeatherOWM;

/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {


    /*16h path blat!!! */
    <T> T getDetailWeatherState(String lat, String lon);

    /*weather detail for plase*/
    CurrentWeatherOWM getCurrentWeatherState(String lat, String lon);

    /*forcast 5/3h*/
    <T> T getListWeatherState(String lat, String lon);
}

