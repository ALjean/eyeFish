package com.jean.analyzers;

import java.util.List;

public interface WeatherAnalyzer {

	public double weatherStateAnalyzer(List<WeatherState> weatherState);

	public double windAnalyzer(Wind wind, double temperature);

	public double pressureAnalyzer(int[] pressures, double temperature);
	
	public double badWeatherAnalyzer(double rain, double clouds, double temperature);

}
