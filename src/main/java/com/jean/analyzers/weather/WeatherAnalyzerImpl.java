package com.jean.analyzers.weather;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.jean.analyzers.weather.WindDirectionConverter.Direction;
import com.jean.analyzers.weather.WindDirectionConverter.MinMaxHolder;

@Component
public class WeatherAnalyzerImpl implements WeatherAnalyzer {

	@Override
	public double stabilityChecker(double[] temperatureParams) {

		double result = 0;
		int countDay = 1;

		double generalChange = Math.abs((temperatureParams[temperatureParams.length - 1] - temperatureParams[0]));

		for (int i = 0; i < temperatureParams.length - 1; i++) {

			if (generalChange > ConstantsAnalyzer.CRITICAL_TEMP_CHANGES_ALL_PERIOD) {
				return ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES / 2;
			}

			double dayChange = Math.abs(temperatureParams[i + 1] - temperatureParams[i]);

			if (dayChange > 0 && dayChange < ConstantsAnalyzer.MIN_TEMP_CHANGES_PER_DAY) {
				result += 0.01;
			} else if (dayChange > ConstantsAnalyzer.MAX_TEMP_CHANGES_PER_DAY) {
				result = 0;
			} else {
				result += dayChange * ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES;
			}

			countDay++;
		}
		if (result == 0) {
			return ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES / 2;
		} else {
			return Math.abs((result / countDay) - 100);
		}
	}

	@Override
	public double windChecker(double temperature, double degrees, double speed) {

		WindDirectionConverter windConverter = new WindDirectionConverter();
		Direction direction = windConverter.getDirection(degrees);
		
		double result = 0;

		if (temperature > ConstantsAnalyzer.CRITICAL_HIGH_TEMP
				&& (direction.getWay().equals("N") || direction.getWay().equals("NNE")
						|| direction.getWay().equals("NE") || direction.getWay().equals("NNW"))) {

			if (speed > 7) {
				result = 90.5;
			}
			if (speed > 5) {
				result = 80.5;
			}
			if (speed > 3.5) {
				result = 70.5;
			}

		} else {
			result = direction.getActivity();
		}

		return result;
	}

	@Override
	public double pressureChecker(double[] pressureParams) {

		double result = 0;
		int countDay = 1;

		double generalChange = Math.abs(pressureParams[pressureParams.length - 1] - pressureParams[0]);

		for (int i = 0; i < pressureParams.length - 1; i++) {

			if (generalChange > ConstantsAnalyzer.CRITICAL_TEMP_CHANGES_ALL_PERIOD) {
				return ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES / 2;
			}

			double dayChange = Math.abs(pressureParams[i + 1] - pressureParams[i]);

			if (dayChange > 0 && dayChange < ConstantsAnalyzer.MIN_TEMP_CHANGES_PER_DAY) {
				result += 0.01;
			} else if (dayChange > ConstantsAnalyzer.MAX_PRESSURE_CHANGES_PER_DAY) {
				result = 0;
			} else {
				result += dayChange * ConstantsAnalyzer.PERCENT_PRESSURE_CHANGES;
			}

			countDay++;
		}
		if (result == 0) {
			return ConstantsAnalyzer.PERCENT_PRESSURE_CHANGES / 2;
		} else {
			return Math.abs((result / countDay) - 100);
		}
	}

}
