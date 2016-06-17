package com.jean.servlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jean.entity.CurrentWeather;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.enums.RedisCoordKey;
import com.jean.service.WeatherService;
import com.jean.servlet.model.Coordinates;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.current.CurrentWeatherOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;
import com.jean.util.MapperOWM;
import com.jean.util.RedisCacheStore;

@RestController
@RequestMapping("/weathers")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@Autowired
	private RedisCacheStore casheStore;

	@RequestMapping(value = "/forecast", method = RequestMethod.GET, produces = "application/json")
	public GeneralHourWeather getHourWeathers(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		GeneralHourWeather hourWeather = null;

		hourWeather = casheStore.findHourWeather(new Coordinates(Double.parseDouble(lon), Double.parseDouble(lat)));
		if (hourWeather == null) {
			GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = weatherService.getHourWeathers(lat, lon);
			hourWeather = MapperOWM.buildModelHourWeather(hourWeatherOWM);
			casheStore.setHourWeather(hourWeather);
		}
		return hourWeather;
	}

	@RequestMapping(value = "/daily", method = RequestMethod.GET, produces = "application/json")
	public GeneralDayWeather getDayWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		GeneralDayWeather dayWeather = null;
		
		dayWeather = casheStore.findDayWeather((new Coordinates(Double.parseDouble(lon), Double.parseDouble(lat))));
		if (dayWeather == null) {
			GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = weatherService.getDayWeatherState(lat, lon);
			dayWeather = MapperOWM.buildModelDayWeather(dayWeatherOWM);
			casheStore.setDayWeather(dayWeather);
		}
		return dayWeather;
	}

	//todo
	@RequestMapping(value = "/current", method = RequestMethod.GET, produces = "application/json")
	public CurrentWeather getCurrentWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		CurrentWeatherOWM currentWeatherOWM = weatherService.getCurrentWeatherState(lat, lon);
		return MapperOWM.buildModelCurrentWeather(currentWeatherOWM);
	}
}
