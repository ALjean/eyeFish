package com.jean.analyzers.weather;

import org.springframework.stereotype.Component;

import com.jean.enums.PressureStates;

@Component
public class NibbleCheckerImpl implements NibbleChecker {

	
	@Override
	public double isRain(double rain) {

		double result = 0;
		if (rain >= ConstantsAnalyzer.MAX_RAIN_VOLUME) {
			result = ConstantsAnalyzer.HEAVY_RAIN_POINT;
		} else if (rain > ConstantsAnalyzer.MIN_RAIN_VOLUME && rain <= ConstantsAnalyzer.MIN_RAIN_VOLUME) {
			result = ConstantsAnalyzer.LIGHT_RAIN_POINT;
		}
		return result;
	}

	@Override
	public double isWind(double degrees, double speed) {

		double result = 0;

		if (speed > ConstantsAnalyzer.CRITICAL_WIND_SPEED) {
			result = ConstantsAnalyzer.WIND_POINT;
		}
		return result;
	}

	@Override
	public GeneralNibbleState checkPressure(double[] press) {

		GeneralNibbleState pressureState = new GeneralNibbleState();
		int countHigh = 0;
		int countLow = 0;

		if (isStability(press, ConstantsAnalyzer.MAX_PRESSURE_CHANGES)) {
			if (isStability(press, ConstantsAnalyzer.MIN_PRESSURE_CHANGES)) {
				for (int i = 0; i < press.length; i++) {
					if (press[i] >= ConstantsAnalyzer.HIGH_PRESSURE_LEVEL) {
						countHigh++;
					} else if (press[i] >= ConstantsAnalyzer.LOW_PRESSURE_LEVEL) {
						countLow++;
					}
				}
				if (countHigh == press.length) {
					pressureState.setNibbleLevel(ConstantsAnalyzer.HIGH_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_STABILITY_HIGH.name());
				} else if (countLow == press.length) {
					pressureState.setNibbleLevel(ConstantsAnalyzer.LOW_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_STABILITY_LOW.name());
				} else if (pressureState.getNibbleLevel() == 0) {
					pressureState.setNibbleLevel(ConstantsAnalyzer.STABILITY_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_STABILITY.name());
				}
			} else {
				if (press[press.length - 1] - press[0] > 0) {
					pressureState.setNibbleLevel(ConstantsAnalyzer.RISE_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_RISE.name());
				} else {
					pressureState.setNibbleLevel(ConstantsAnalyzer.DOWN_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_DOWN.name());
				}
			}
		} else {
			pressureState.setNibbleLevel(ConstantsAnalyzer.UNSTABILITY_PRESSURE_POINT);
			pressureState.setMessage(PressureStates.IS_UNSTABILITY.name());
		}
		return pressureState;
	}

	private boolean isStability(double[] params, double constantValue) {
		boolean result = false;
		int count = 0;

		for (int i = 0; i < params.length - 1; i++) {
			double changeRange = Math.abs(params[i + 1] - params[i]);
			if (changeRange == 0 || changeRange <= constantValue) {
				count++;
			}
		}
		if (count == params.length - 1) {
			result = true;
		}
		return result;
	}
}
