package com.jean.analyzers.fish;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.entity.Fish;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;

public interface BehaviorAnalyzer {
	
	public double getGeneralActivityLevel(GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeather);
	
	public BehaviorDTO getFishBehavior(GeneralWeatherStateOWM<HoursWeatherDataOWM> hoursWeather, Fish fihs);
}
