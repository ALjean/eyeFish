package com.jean.analyzers.behavior;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.analyzing.Behavior;
import com.jean.dao.entity.fish.Fish;
import com.jean.entity.weather.HourWeather;

public interface BehaviorAnalyzer {
	
	Behavior getFishBehavior(List<HourWeather> hourWeathers, Fish fish, boolean withBaits, String date) throws DaoDfmException;
}
