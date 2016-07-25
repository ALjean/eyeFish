package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.analyzers.fish.BehaviorDTO;
import com.jean.entity.GeneralHourWeather;

public interface BehaviorService {

	public BehaviorDTO getFishBehavior(String currentDate, int fishId, GeneralHourWeather generalHourWeather) throws DaoDfmException, CustomDfmException;
	
}
