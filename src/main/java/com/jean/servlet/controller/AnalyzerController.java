package com.jean.servlet.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class AnalyzerController {


    @RequestMapping(value = "/locationWeathers", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void weathersForLocation(String city) {
        //return list weather from curent day
    }

    @RequestMapping(value = "/graphDataByOneDay", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getGraphDataByOneDay(int idFish, int weatherId) {
        // return data for graphicViews
    }


}
