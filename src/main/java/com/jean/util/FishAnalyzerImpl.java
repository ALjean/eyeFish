package com.jean.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.CustomDfmException;
import com.jean.dao.WeatherDao;
import com.jean.dao.impl.WeatherDaoImpl;
import com.jean.entity.Fish;
import com.jean.entity.Weather;
import com.jean.entity.WeatherState;

@Component
public class FishAnalyzerImpl implements FishAnalyzer {
    
   @Autowired
    private WeatherDao weatherDao;

    public List<String> getHungryRating(Fish fish) throws CustomDfmException{
	
	List<Weather> listWeather = new ArrayList<Weather>();
		
	listWeather = weatherDao.getLimitWeatherByDate();
	
	Map<String, WeatherState> hungry = fish.getHungry();
	
	List<String> listState = new ArrayList<String>();
	
	for(Weather weather : listWeather){
	    
	    for(Map.Entry<String, WeatherState> entry : hungry.entrySet()){
		
		if(entry.getValue().getMin() < weather.getTempDay() || entry.getValue().getMax() < weather.getTempDay()){
		    listState.add(entry.getKey());
		}
		
	    }
	}
	
	return listState;
	
    }
}
