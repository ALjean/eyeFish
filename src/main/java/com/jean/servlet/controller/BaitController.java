package com.jean.servlet.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.service.BaitService;

@RestController
@RequestMapping("/baits")
public class BaitController {

	@Autowired
	private BaitService baitService;

	@RequestMapping(value = "{baitId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getBaits(@PathVariable("baitId") int baitId) {

		List<Bait> baits = new ArrayList<Bait>();

		try {
			baits = baitService.getBaits(baitId, null, null, null, null);

			if (baits.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (DaoDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Bait>>(baits, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getBaits(
			@RequestParam(value = "baitType", required = false) String baitType,
			@RequestParam(value = "baitName", required = false)String baitName, 
			@RequestParam(value = "fishId", required = false)Integer fishId, 
			@RequestParam(value = "date", required = false)String date) {

		List<Bait> baits = new ArrayList<Bait>();

		try {
			baits = baitService.getBaits(null, baitType, baitName, fishId, date);

			if (baits.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (DaoDfmException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<Bait>>(baits, HttpStatus.OK);
	}
}
