package com.jean.analyzers.fish;

import java.util.List;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.GeneralNibbleState;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;

public interface BehaviorAnalyzer {
	
	public BehaviorDTO getFishBehavior(List<HourWeather> hourWeathers, Fish fish, GeneralNibbleState nibbleState);

	public GeneralNibbleState getGeneralNibble(List<HourWeather> hourWeather);
}
