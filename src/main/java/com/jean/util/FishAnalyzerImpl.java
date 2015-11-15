package com.jean.util;

import java.util.*;

import com.jean.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.CustomDfmException;
import com.jean.dao.WeatherDao;
import com.jean.entity.AbstractFish;
import com.jean.entity.Weather;

@Component
public class FishAnalyzerImpl implements FishAnalyzer {

    @Autowired
    private WeatherDao weatherDao;

    private Map<String, Integer> raiting;

    public List<String> getHungryRating(AbstractFish fish) throws CustomDfmException {

        List<Weather> listWeather = weatherDao.getLimitWeatherByDate(new Date());

//        Map<String, WeatherState> hungry = fish.getHungry();



        List<String> listState = new ArrayList<>();


        for (Weather weather : listWeather) {

//            for (Map.Entry<String, WeatherState> entry : hungry.entrySet()) {
//                WeatherState param = entry.getValue();
//                    if (param.getMin() < weather.getTempDay() || param.getMax() < weather.getTempDay()) {
//                        //raiting.put(entry.getKey(), new Integer(value));
//                    }
//
//            }

        }

        return listState;

    }

    public FishAnalyzerImpl() {

        this.raiting = new HashMap<>();
        for (Constants.Hungry stateMark : Constants.Hungry.values()) {
            raiting.put(stateMark.toString(), null);
        }
    }


}
