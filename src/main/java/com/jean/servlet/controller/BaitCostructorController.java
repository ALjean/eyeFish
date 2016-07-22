package com.jean.servlet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.entity.OptimalBaitsDTO;
import com.jean.enums.RedisKeys;
import com.jean.service.BaitConstructorService;
import com.jean.service.WeatherService;
import com.jean.servlet.model.Coordinates;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;
import com.jean.util.MapperOWM;
import com.jean.util.RedisCacheStore;

@RestController
@RequestMapping("/service")
public class BaitCostructorController {

	@Autowired
	private BaitConstructorService baitService;
	@Autowired
	private WeatherService weatherService;
	@Autowired
	private RedisCacheStore casheStore;

	@RequestMapping(value = "optimal/baits", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getOptimalBaits(

			@RequestParam(value = "baitName", required = false) String baitName,
			@RequestParam(value = "baitType", required = false) String baitType, 
			@RequestParam("fishId") String fishId,
			@RequestParam("lon") String lon, 
			@RequestParam("lat") String lat, 
			@RequestParam("date") String date) {

		OptimalBaitsDTO optimalBaitsDTO = new OptimalBaitsDTO();

		try {
			GeneralHourWeather generalHourWeather = casheStore.findHourWeather(
					new Coordinates(RedisKeys.HourWeather, Float.parseFloat(lon), Float.parseFloat(lat)));
			if (generalHourWeather == null) {
				GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = weatherService.getHourWeathers(lat, lon);
				generalHourWeather = MapperOWM.buildModelHourWeather(hourWeatherOWM);
				casheStore.setWeather(generalHourWeather);
			}

			List<HourWeather> hourWeathers = new ArrayList<HourWeather>();
			for (HourWeather hourWeather : generalHourWeather.getHourWeathers()) {
				if (hourWeather.getDateText().substring(0, 10).trim().equals(date)) {
					hourWeathers.add(hourWeather);
				}
			}

			for (HourWeather hourWeather : hourWeathers) {
				optimalBaitsDTO.getOptimalBaits().put(hourWeather.getDateText().substring(11),
						baitService.getOptimalBaits(Integer.parseInt(fishId), baitType, baitName, hourWeather, false));
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (CustomDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (DaoDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<OptimalBaitsDTO>(optimalBaitsDTO, HttpStatus.OK);

	}
}
