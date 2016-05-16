package com.jean.analyzers.weather;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.jean.analyzers.weather.WindDirectionConverter.DirectionMap;
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
				countDay = 0;
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

		WindDirectionConverter windConverter = WindDirectionConverter.getInstance();

		Map<Integer, MinMaxHolder> bofortScale = windConverter.getBofortScale();

		double result = 1;

		if (speed > bofortScale.get(5).getStartValue()) {
			result = 6.25;
		} else if (speed >= bofortScale.get(0).getStartValue() && speed <= bofortScale.get(2).getEndValue()) {
			result = 0.0;
		} else {

			DirectionMap directionMap = WindDirectionConverter.getInstance().getDirectionObject(degrees);

			String direction = directionMap.getDirection();

			if (temperature > ConstantsAnalyzer.CRITICAL_HIGH_TEMP
					&& (direction.equals("N") | direction.equalsIgnoreCase("NNE") | direction.equalsIgnoreCase("NE")
							| direction.equalsIgnoreCase("NNW"))) {

				if (speed > bofortScale.get(3).getStartValue() && speed < bofortScale.get(3).getEndValue()) {
					result = 70.23;
				}
				if (speed > bofortScale.get(4).getStartValue() && speed < bofortScale.get(4).getEndValue()) {
					result = 80.52;
				}
				if (speed > bofortScale.get(5).getStartValue() && speed < bofortScale.get(5).getEndValue()) {
					result = 90.52;
				}
			} else {
				result = directionMap.getActivity();
			}
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

			if (dayChange > 0 && dayChange < ConstantsAnalyzer.MIN_PRESSURE_CHABGES_PER_DAY) {
				result += 0.01;
			} else if (dayChange > ConstantsAnalyzer.MAX_PRESSURE_CHANGES_PER_DAY) {
				result = 0;
				countDay = 0;
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

	public static void main(String[] args) {

		WeatherAnalyzer analyzer = new WeatherAnalyzerImpl();

		double[] temperatureParams = { 32.5, 12.8, 33, 48.5, 31.2 };

		double[] pressureParams = { 740.25, 742.3, 743, 743.4, 736 };

		System.out.println("Stability of weather are: " + analyzer.stabilityChecker(temperatureParams));

		System.out.println("Pressure activity are: " + analyzer.pressureChecker(pressureParams));

		System.out.println("Wind activity is " + analyzer.windChecker(32, 348, 5.6));

	}

}
