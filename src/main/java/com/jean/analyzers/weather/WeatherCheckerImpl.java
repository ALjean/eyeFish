package com.jean.analyzers.weather;

import org.springframework.stereotype.Component;

@Component
public class WeatherCheckerImpl implements WeatherChecker {

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
	public double checkWind(double degrees, double speed) {

		double result = 0;

		if (speed > ConstantsAnalyzer.CRITICAL_WIND_SPEED) {
			result = ConstantsAnalyzer.WIND_POINT;
		}
		return result;
	}


	@Override
	public double checkTemperature(double[] temps) {

		double result = 0;

		if (isStability(temps, ConstantsAnalyzer.MAX_TEMP_CHANGES_PER_DAY)) {
			result = ConstantsAnalyzer.STABILITY_TEMP_POINT;
		} else {
			result = ConstantsAnalyzer.UNSTABILITY_TEMP_POINT;
		}
		return result;
	}

	@Override
	public double checkPressure(double[] press) {

		double result = 0;
		int countHigh = 0;
		int countLow = 0;

		if (isStability(press, ConstantsAnalyzer.MAX_PRESSURE_CHANGES_PER_DAY)) {
			if (isStability(press, ConstantsAnalyzer.MAX_PRESSURE_CHANGES_FOR_STABILITY)) {
				for (int i = 0; i < press.length; i++) {
					if (press[i] >= ConstantsAnalyzer.HIGH_PRESSURE_LEVEL) {
						countHigh++;
					} else if (press[i] >= ConstantsAnalyzer.LOW_PRESSURE_LEVEL) {
						countLow++;
					}
				}
				if (countHigh == press.length) {
					result = ConstantsAnalyzer.HIGH_PRESSURE_POINT;
				} else if (countLow == press.length) {
					result = ConstantsAnalyzer.LOW_PRESSURE_POINT;
				} else if (result == 0) {
					result = ConstantsAnalyzer.STABILITY_PRESSURE_POINT;
				}
			} else {
				if (press[press.length - 1] - press[0] > 0) {
					result = ConstantsAnalyzer.RISE_PRESSURE_POINT;
				} else {
					result = ConstantsAnalyzer.DOWN_PRESSURE_POINT;
				}
			}
		} else {
			result = ConstantsAnalyzer.UNSTABILITY_PRESSURE_POINT;
		}
		return result;
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
