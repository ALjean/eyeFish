package com.jean.analyzers.weather;

public interface WeatherChecker {

	boolean isStabilityTemp(double[] temp);

	boolean isStabilityPress(double[] press);

	boolean isPressHigh(double[] press);

	boolean isPressLow(double[] press);

	boolean isRisePressure(double[] press);

	boolean isWindHelp(double temp, double degrees, double speed);
	
	boolean isRainHelp(double rainVolume, double[] temp);

	boolean isLongRain(double[] rains);

}