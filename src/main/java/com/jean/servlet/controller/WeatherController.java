package com.jean.servlet.controller;

import com.jean.CustomDfmException;
import com.jean.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jean.entity.CurrentWeather;

@RestController
@RequestMapping("/weathers")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/forecast", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getHourWeathers(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		try {
			return new ResponseEntity<>(weatherService.getHourWeathers(lon, lat), HttpStatus.OK);
		} catch (CustomDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/daily", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getDayWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

		try {
			return new ResponseEntity<>(weatherService.getDayWeatherState(lon, lat), HttpStatus.OK);
		} catch (CustomDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// todo
	@RequestMapping(value = "/current", method = RequestMethod.GET, produces = "application/json")
	public CurrentWeather getCurrentWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {
		return weatherService.getCurrentWeatherState(lat, lon);
	}
}
