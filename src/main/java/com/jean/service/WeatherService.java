package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.entity.owm.current.CurrentWeatherOWM;
import com.jean.entity.weather.GeneralDayWeather;
import com.jean.entity.weather.GeneralHourWeather;

/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {


//	forcast 5/3h
	GeneralHourWeather getGeneralHourWeather(String lon, String lat) throws CustomDfmException;
//	16h path blat!!!
	GeneralDayWeather getGeneralDayWeather(String lon, String lat) throws CustomDfmException;

	CurrentWeatherOWM getCurrentWeatherState(String lat, String lon);

}
