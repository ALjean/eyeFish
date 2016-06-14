package com.jean.service;

import com.jean.servlet.model.owm.current.CurrentWeatherOWM;

/**
 * Created by stas on 18.07.15.
 */
public interface WeatherService {

	/* weather detail for plase */
	public CurrentWeatherOWM getCurrentWeatherState(String lat, String lon);

	/* 16h path blat!!! */
	public <T> T getDayWeatherState(String lat, String lon);

	/* forcast 5/3h */
	public <T> T getHourWeathers(String lat, String lon);
}
