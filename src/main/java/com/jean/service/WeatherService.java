package com.jean.service;


/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {

    <T> T getCurrentWeatherState(String lat, String lon);

    <T> T getListWeatherState(String lat, String lon);
}

