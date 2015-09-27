package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.entity.Fish;
import com.jean.entity.Weather;
import com.jean.model.FishDTO;

import java.util.Date;

public interface FishService {
    
    FishDTO getCurrentFishState(Weather weather);

    int getBehaviorFishByDay(Fish fish, Date date) throws CustomDfmException;
    
}
