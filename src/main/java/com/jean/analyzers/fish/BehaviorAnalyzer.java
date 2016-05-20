package com.jean.analyzers.fish;

import java.util.List;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;

public interface BehaviorAnalyzer {
	
	public double getGeneralActivityLevel(List<DayWeather> dayWeathers);
	
	public BehaviorDTO getFishBehavior(List<HourWeather> hourWeathers, Fish fish, double generalvalue);
}
