package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.entity.CurrentWeather;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;

public interface WeatherService {


    /* weather detail for plase */
    CurrentWeather getCurrentWeatherState(String lat, String lon);

    /* 16h path blat!!! */
    GeneralDayWeather getDayWeatherState(String lat, String lon) throws CustomDfmException;

    /* forcast 5/3h */
    GeneralHourWeather getHourWeathers(String lat, String lon) throws CustomDfmException;
}
