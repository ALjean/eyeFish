package com.jean.analyzers.fish;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.ConstantsAnalyzer;
import com.jean.analyzers.weather.WeatherChecker;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;

import com.jean.entity.HourWeather;
import com.mysql.fabric.xmlrpc.base.Array;

@Component
public class BehaviorAnalyzerImpl implements BehaviorAnalyzer {

	@Autowired
	private WeatherChecker weatherChecker;

	@Override
	public double getGeneralActivityLevel(List<DayWeather> dayWeathers) {
		return 0;

	}

	@Override
	public BehaviorDTO getFishBehavior(List<HourWeather> hourWeathers, Fish fish, double generalNibble) {
		return null;

	}

}
