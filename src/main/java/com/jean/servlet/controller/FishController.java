package com.jean.servlet.controller;

import com.jean.DaoDfmException;
import com.jean.entity.fish.Fish;
import com.jean.service.FishService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fishes")
public class FishController {

	@Autowired
	private FishService fishService;

	@RequestMapping(value = "/{fishId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getFishes(@PathVariable("fishId") Integer fishId) {

		List<Fish> fishes = new ArrayList<Fish>();

		try {
			fishes = fishService.getFishes(fishId, null, null, null, null);
			
			if(fishes.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (DaoDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Fish>>(fishes, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getFishes(@RequestParam(value = "fishName", required = false) String fishName,
			@RequestParam(value = "fishType", required = false) String fishType,
			@RequestParam(value = "dayActivity", required = false) String dayActivity,
			@RequestParam(value = "livingArea", required = false) String livingArea) {

		List<Fish> fishes = new ArrayList<Fish>();

		try {
			fishes = fishService.getFishes(null, fishName, fishType, dayActivity, livingArea);
			
			if(fishes.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (DaoDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Fish>>(fishes, HttpStatus.OK);
	}
}
