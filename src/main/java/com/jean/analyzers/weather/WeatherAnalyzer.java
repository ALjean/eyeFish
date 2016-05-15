package com.jean.analyzers.weather;


public interface WeatherAnalyzer {

	double stabilityChecker(double[] temperatureParams);

	double windChecker(double temperature, double degrees, double speed);

	double pressureChecker(double[] pressureParams);
	
	

}
