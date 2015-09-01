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
import com.jean.entity.RangeWeatherParameters;

@Component
public class FishAnalyzerImpl implements FishAnalyzer {

    @Autowired
    private WeatherDao weatherDao;
    
    private Map<String, Integer> raiting;

    public List<String> getHungryRating(Fish fish) throws CustomDfmException {

	List<Weather> listWeather = new ArrayList<Weather>();

	listWeather = weatherDao.getLimitWeatherByDate();

	Map<String, List<RangeWeatherParameters>> hungry = fish.getHungry();

	List<String> listState = new ArrayList<String>();

	for (Weather weather : listWeather) {

	    for (Map.Entry<String, List<RangeWeatherParameters>> entry : hungry.entrySet()) {
		
		for(RangeWeatherParameters param : entry.getValue()){
		    if(param.getMin() < weather.getTempDay() || param.getMax() < weather.getTempDay()){
			//raiting.put(entry.getKey(), new Integer(value));
		    }
		}
	    }

	}

	return listState;

    }

    public FishAnalyzerImpl() { 
	
	this.raiting = new HashMap<String, Integer>();
	for (Constants.StateMarkHungry stateMark : Constants.StateMarkHungry.values()) {
	    raiting.put(stateMark.toString(), null);
	}
    }
    
    

}
