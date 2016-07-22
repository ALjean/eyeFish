package com.jean.servlet.controller;

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
import com.jean.analyzers.fish.BehaviorDTO;
import com.jean.service.BehaviorService;

@RestController
@RequestMapping("/service")
public class AnalyzerController {

	@Autowired
	private BehaviorService behaviorService;

	@RequestMapping(value = "behavior/{fishId}/{date}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getBehavior(@PathVariable("fishId") int fishId, @PathVariable("date") String date,
			@RequestParam("lon") float lon, @RequestParam("lat") float lat) {

		BehaviorDTO behaviorDTO = null;

		try {
			behaviorDTO = behaviorService.getFishBehavior(date, fishId, lon, lat);
		} catch (DaoDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (CustomDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<BehaviorDTO>(behaviorDTO, HttpStatus.OK);
	}

}
