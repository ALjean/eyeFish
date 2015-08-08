package com.jean.service;

import com.jean.model.owm.GeneralWeatherStateOWM;


/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {

    GeneralWeatherStateOWM getHoursWeatherState();

    GeneralWeatherStateOWM getDayWeatherState();
}

