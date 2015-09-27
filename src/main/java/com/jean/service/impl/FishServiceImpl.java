package com.jean.service.impl;


import com.jean.CustomDfmException;
import com.jean.dao.WeatherDao;
import com.jean.entity.Fish;
import com.jean.entity.Weather;
import com.jean.model.FishDTO;
import com.jean.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FishServiceImpl implements FishService {

    @Autowired
    private WeatherDao weatherDao;

    @Override
    public FishDTO getCurrentFishState(Weather weather) {

	return null;
    }

    public int getBehaviorFishByDay(Fish fish, Date date) throws CustomDfmException {
        List<Weather> weathers = weatherDao.getLimitWeatherByDate(date);


        return 0;
    }

}
