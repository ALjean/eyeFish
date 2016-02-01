package com.jean.analyzers.weather;


public interface WeatherAnalyzer {

	public double StabilityChecker(float[] temperatureParams);

	public double windChecker(double temperature, double degrees, double speed);

	public double pressureChecker(float[] pressureParams);
	
	

}
