package com.jean.analyzers.checkers;

import java.util.List;

import com.jean.entity.GeneralNibbleState;

public interface NibbleChecker {

	double isRain(double rain);

	double isWind(double degrees, double speed);

	GeneralNibbleState checkPressure(double[] press);
	
	public GeneralNibbleState checkPressure(List<Float> press);

}