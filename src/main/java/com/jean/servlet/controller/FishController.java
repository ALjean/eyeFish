package com.jean.servlet.controller;

import com.jean.entity.fish.Fish;
import com.jean.service.FishService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fishes")
public class FishController {

    @Autowired
    private FishService fishService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getFishes() {

        List<Fish> fishes = fishService.getAllFishes();

        return new ResponseEntity<>(fishes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getByFishById(@PathVariable("id") Long id) {

        Fish fish = fishService.getById(id);

        return new ResponseEntity<>(fish, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> saveFish(Fish fish) {

        Fish savedFish = fishService.save(fish);

        return new ResponseEntity<>(savedFish, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> updateFish(Fish fish) {

        Fish updatedFish = fishService.update(fish);

        return new ResponseEntity<>(updatedFish, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> deleteFish(@PathVariable("id") Long id) {

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
