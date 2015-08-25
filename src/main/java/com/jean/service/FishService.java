package com.jean.service;

import com.jean.entity.FishDTO;
import com.jean.entity.Weather;

public interface FishService {
    
    public FishDTO getCurrentFishState(Weather weather);
    
}
