package com.jean.analyzers.weather;


public interface WeatherAnalyzer {

	double stabilityChecker(float[] temperatureParams);

	double windChecker(double temperature, double degrees, double speed);

	double pressureChecker(float[] pressureParams);
	
	

}
