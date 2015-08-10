package com.jean.service;


/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {

    public <T> T  getHoursWeatherState();

    public <T> T  getDayWeatherState();
}

