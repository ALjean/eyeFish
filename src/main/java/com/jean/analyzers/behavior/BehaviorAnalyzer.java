package com.jean.analyzers.behavior;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.Behavior;
import com.jean.entity.Fish;
import com.jean.entity.HourWeather;

public interface BehaviorAnalyzer {
	
	public Behavior getFishBehavior(List<HourWeather> hourWeathers, Fish fish, boolean withBaits, String date) throws DaoDfmException;
}
