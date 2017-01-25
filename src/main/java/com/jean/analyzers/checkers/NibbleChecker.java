package com.jean.analyzers.checkers;

import java.util.List;

import com.jean.entity.analyzing.GeneralNibbleState;

public interface NibbleChecker {

	float isRain(double rain);

	float isWind(double degrees, double speed);

	GeneralNibbleState checkPressure(double[] press);
	
	public GeneralNibbleState checkPressure(List<Float> press);

}