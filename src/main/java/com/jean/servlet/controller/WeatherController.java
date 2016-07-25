package com.jean.servlet.controller;

import com.jean.CustomDfmException;
import com.jean.enums.RedisKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getHourWeathers(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		try {
			return new ResponseEntity<GeneralHourWeather>(casheStore.getGeneralHourWeather(lon, lat), HttpStatus.OK);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);			
		} catch (CustomDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/daily", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getDayWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		try {
			return new ResponseEntity<GeneralDayWeather>(casheStore.getGeneralDayWeather(lon, lat), HttpStatus.OK);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);			
		} catch (CustomDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	// todo
	@RequestMapping(value = "/current", method = RequestMethod.GET, produces = "application/json")
	public CurrentWeather getCurrentWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		CurrentWeatherOWM currentWeatherOWM = weatherService.getCurrentWeatherState(lat, lon);
		return MapperOWM.buildModelCurrentWeather(currentWeatherOWM);
	}
}
