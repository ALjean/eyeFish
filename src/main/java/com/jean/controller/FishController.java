package com.jean.controller;

import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;
import com.jean.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController("/fish")
public class FishController {

    @Autowired
    private FishService fishService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean create(@RequestBody AbstractFish fish) throws SQLException, CustomDfmException {
        return fishService.create(fish);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AbstractFish get(@PathVariable int id) throws CustomDfmException {
        return fishService.get(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AbstractFish> getAll(){
        return fishService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        fishService.remove(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody AbstractFish fish){
        fishService.update(fish);
    }
}
