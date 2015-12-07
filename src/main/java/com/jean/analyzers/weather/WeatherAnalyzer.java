package com.jean.analyzers.weather;


public interface WeatherAnalyzer {

	public double StabilityChecker(float[] temperatureParams);

	public double windAnalyzer(Wind wind, double temperature);

	public double pressureAnalyzer(int[] pressures, double temperature);
	
	public double badWeatherAnalyzer(double rain, double clouds, double temperature);

}
