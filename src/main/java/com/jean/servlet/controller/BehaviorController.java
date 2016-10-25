package com.jean.servlet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Behavior;
import com.jean.entity.BehaviorsDTO;
import com.jean.entity.GeneralHourWeather;
import com.jean.service.BehaviorService;
import com.jean.util.RedisCacheStore;

@RestController
@RequestMapping("/service")
public class BehaviorController {

	@Autowired
	private BehaviorService behaviorService;

	@Autowired
	private RedisCacheStore casheStore;

	@RequestMapping(value = "behavior", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getBehavior(@RequestParam("fishIds") List<Integer> fishIds, @RequestParam("dates") List<String> calculatedDates,
			@RequestParam("lon") String lon, @RequestParam("lat") String lat) {

		List<BehaviorsDTO> behaviorDTOList = new ArrayList<>();

		try {

			GeneralHourWeather generalHourWeather = casheStore.getGeneralHourWeather(lon, lat);

			if (fishIds.size() == 0) {
				throw new CustomDfmException("Array of fishId is empty");
			}

		
			behaviorDTOList = behaviorService.getFishBehavior(calculatedDates, fishIds, generalHourWeather);
			

		} catch (DaoDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (CustomDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<BehaviorsDTO>>(behaviorDTOList, HttpStatus.OK);
	}

}
