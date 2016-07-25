package com.jean.analyzers.weather;

import java.util.List;

public interface NibbleChecker {

	double isRain(double rain);

	double isWind(double degrees, double speed);

	GeneralNibbleState checkPressure(double[] press);
	
	public GeneralNibbleState checkPressure(List<Float> press);

}