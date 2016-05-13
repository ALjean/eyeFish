package com.jean.service;


/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {

    <T> T getHoursWeatherState(String lat, String lon);

    <T> T getDayWeatherState(String lat, String lon);
}

