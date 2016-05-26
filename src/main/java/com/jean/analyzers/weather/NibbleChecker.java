package com.jean.analyzers.weather;

public interface NibbleChecker {

	double isRain(double rain);

	double isWind(double degrees, double speed);

	GeneralNibbleState checkPressure(double[] press);

}