package com.jean.service.impl;


import com.jean.CustomDfmException;
import com.jean.dao.WeatherDao;
import com.jean.entity.AbstractFish;
import com.jean.entity.Weather;
import com.jean.model.FishDto;
import com.jean.service.FishAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FishAnalyzerServiceImpl implements FishAnalyzerService {

    @Autowired
    private WeatherDao weatherDao;

    @Override
    public FishDto getCurrentFishState(Weather weather) {

	return null;
    }

    public int getBehaviorFishByDay(AbstractFish fish, Date date) throws CustomDfmException {
        List<Weather> weathers = weatherDao.getLimitWeatherByDate(date);




        return 0;
    }

}
