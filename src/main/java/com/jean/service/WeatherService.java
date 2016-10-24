package com.jean.service;

import com.jean.servlet.model.owm.current.CurrentWeatherOWM;

/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {

	/* weather detail for plase */
	CurrentWeatherOWM getCurrentWeatherState(String lat, String lon);

	/* 16h path blat!!! */
	<T> T getDayWeatherState(String lat, String lon);

	/* forcast 5/3h */
	<T> T getHourWeathers(String lat, String lon);
}
