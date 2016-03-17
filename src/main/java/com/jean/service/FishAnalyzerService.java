package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Fish;
import com.jean.entity.Weather;
import com.jean.servlet.model.FishDto;

import java.util.Date;

public interface FishAnalyzerService {
    
    FishDto getCurrentFishState(Weather weather);

    int getBehaviorFishByDay(Fish fish, Date date) throws CustomDfmException, DaoDfmException;
    
}
