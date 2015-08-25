package com.jean.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jean.CustomDfmException;
import com.jean.dao.WeatherDao;
import com.jean.entity.Weather;

public class FishAnalyzer {
    
    @Autowired
    WeatherDao weatherDao;

    public List getHungryRating(Date date) throws CustomDfmException{
	
	Map<String, Integer> ratingList = new HashMap<String,Integer>();
	
	List<Weather> listWeather = weatherDao.getAllWeather();
	
	return null;
	
    }
}
