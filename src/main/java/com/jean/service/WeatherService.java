package com.jean.service;


/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {

    <T> T getHoursWeatherState();

    <T> T getDayWeatherState();
}

