package com.jean.servlet.controller;

import java.util.ArrayList;
import java.util.List;

import com.jean.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.analyzers.fish.BehaviorDTO;
import com.jean.entity.GeneralHourWeather;
import com.jean.service.BehaviorService;


@RestController
@RequestMapping("/service")
public class BehaviorController {

	@Autowired
	private BehaviorService behaviorService;

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "behavior/{date}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getBehavior(@RequestParam("fishId") int[] fishId, @PathVariable("date") String date,
			@RequestParam("lon") String lon, @RequestParam("lat") String lat) {

		List<BehaviorDTO> behaviorDTOList = new ArrayList<>();

		try {

			GeneralHourWeather hourWeather = weatherService.getHourWeathers(lon, lat);

			if (fishId.length == 0) {
				throw new CustomDfmException("Array of fishId is empty");
			}

			for (int i = 0; i < fishId.length; i++) {
				behaviorDTOList.add(behaviorService.getFishBehavior(date, fishId[i], hourWeather));
			}

		} catch (DaoDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (CustomDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(behaviorDTOList, HttpStatus.OK);
	}

}
