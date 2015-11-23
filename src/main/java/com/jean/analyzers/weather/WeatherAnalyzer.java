package com.jean.analyzers.weather;

import java.util.List;

import com.jean.model.owm.AverageWeatherParamsOWM;

public interface WeatherAnalyzer {

	public double weatherStateAnalyzer(List<AverageWeatherParamsOWM> weatherState);

	public double windAnalyzer(Wind wind, double temperature);

	public double pressureAnalyzer(int[] pressures, double temperature);
	
	public double badWeatherAnalyzer(double rain, double clouds, double temperature);

}
