package com.jean.servlet.controller;

import com.jean.dao.entity.fish.Fish;
import com.jean.service.FishService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fishes")
public class FishController {

    private static final Logger logger = Logger.getLogger(FishController.class);

    @Autowired
    private FishService fishService;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getFishes() {

        List<Fish> fishes = fishService.getAllFishes();

        logger.info("find fishes size: " + fishes.size());

        return new ResponseEntity<>(fishes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getByFishById(@PathVariable("id") Long id) {

        logger.info("Try get fish with ID: " + id);

        Fish fish = fishService.getById(id);

        return new ResponseEntity<>(fish, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> saveFish(Fish fish) {

        logger.info("Try save fish with name: " + fish.getName());

        Fish savedFish = fishService.save(fish);

        return new ResponseEntity<>(savedFish, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateFish(Fish fish) {
        logger.info("Try save fish with ID: " + fish.getId());

        Fish updatedFish = fishService.update(fish);

        return new ResponseEntity<>(updatedFish, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteFish(@PathVariable("id") Long id) {

        logger.info("Try remove fish with id: " + id);

        fishService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findFishes() {
//TODO find by params
        Set<Fish> fishes = new HashSet<>();

        return new ResponseEntity<>(fishes, HttpStatus.OK);
    }
}
