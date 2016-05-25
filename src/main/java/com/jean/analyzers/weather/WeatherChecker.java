package com.jean.analyzers.weather;

public interface WeatherChecker {

	double isRain(double rain);

	double checkWind(double degrees, double speed);

	double checkTemperature(double[] temps);

	double checkPressure(double[] press);

}