package com.jean.service;

import com.jean.entity.Weather;
import com.jean.model.FishDTO;

public interface FishService {
    
    public FishDTO getCurrentFishState(Weather weather);
    
}
