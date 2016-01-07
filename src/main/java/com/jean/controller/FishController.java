package com.jean.controller;

import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;
import com.jean.service.FishService;
import com.jean.util.DocumentParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/fish")
public class FishController {

    @Autowired
    private FishService fishService;

    @Autowired
    private DocumentParser documentParser;

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
    public void delete(@PathVariable int id) throws SQLException, CustomDfmException {
        fishService.remove(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody AbstractFish fish){
        fishService.update(fish);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadFishData(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream stream = file.getInputStream();

        documentParser.parse(stream);



    }
}
