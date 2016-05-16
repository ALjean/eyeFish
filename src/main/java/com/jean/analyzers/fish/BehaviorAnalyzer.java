package com.jean.analyzers.fish;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.entity.Fish;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;

public interface BehaviorAnalyzer {
	
	public double getGeneralActivityLevel(GeneralDayWeather generalDayWeather);
	
	public BehaviorDTO getFishBehavior(GeneralHourWeather generalHourWeather, Fish fish, double generalvalue, String currentDate);
}
