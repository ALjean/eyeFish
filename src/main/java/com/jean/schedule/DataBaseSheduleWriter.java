package com.jean.schedule;

import org.springframework.beans.factory.annotation.Autowired;

import com.jean.service.WeatherService;
import com.jean.servlet.model.owm.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.HoursWeatherDataOWM;

public class DataBaseSheduleWriter {

	@Autowired
	private WeatherService weatherService;
	
	private GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = weatherService.getDayWeatherState();
	private GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = weatherService.getHoursWeatherState();
	
	
}
