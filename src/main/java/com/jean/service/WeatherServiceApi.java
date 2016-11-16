package com.jean.service;

import com.jean.entity.owm.current.CurrentWeatherOWM;


public interface WeatherServiceApi {

    /* weather detail for plase */
    CurrentWeatherOWM getCurrentWeatherState(String lat, String lon);

    /* 16h path blat!!! */
    <T> T getDayWeatherState(String lat, String lon);

    /* forcast 5/3h */
    <T> T getHourWeathers(String lat, String lon);



}
