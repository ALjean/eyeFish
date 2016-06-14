package com.jean.servlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jean.entity.CurrentWeather;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.service.WeatherService;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.current.CurrentWeatherOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;
import com.jean.util.MapperOWM;

@RestController
@RequestMapping("/weathers")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/forecast", method = RequestMethod.GET, produces = "application/json")
	public GeneralHourWeather getHourWeathers(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = weatherService.getHourWeathers(lat, lon);
		return MapperOWM.buildModelHourWeather(hourWeatherOWM);
	}

	@RequestMapping(value = "/daily", method = RequestMethod.GET, produces = "application/json")
	public GeneralDayWeather getDayWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = weatherService.getDayWeatherState(lat, lon);
		return MapperOWM.buildModelDayWeather(dayWeatherOWM);
	}

	@RequestMapping(value = "/current", method = RequestMethod.GET, produces = "application/json")
	public CurrentWeather getCurrentWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		CurrentWeatherOWM currentWeatherOWM = weatherService.getCurrentWeatherState(lat, lon);
		return MapperOWM.buildModelCurrentWeather(currentWeatherOWM);
	}
}
