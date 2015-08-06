package com.jean.service;

import com.jean.model.owm.DayWeatherDataOWM;
import com.jean.model.owm.GeneralWeatherStateOWM;
import com.jean.model.owm.HoursWeatherDataOWM;

/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {

    GeneralWeatherStateOWM<HoursWeatherDataOWM> getHoursWeatherState();

    GeneralWeatherStateOWM<DayWeatherDataOWM> getDayWeatherState();
}

