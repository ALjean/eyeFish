package com.jean.analyzers.weather;

import org.springframework.stereotype.Component;

import com.jean.util.Utils;

@Component
public class WeatherCheckerImpl implements WeatherChecker {

	@Override
	public boolean isStabilityTemp(double[] temp) {

		boolean result = false;
		int count = 0;

		for (int i = 0; i < temp.length - 1; i++) {
			double changeRange = Math.abs(temp[i + 1] - temp[i]);
			if (changeRange == 0 || changeRange <= ConstantsAnalyzer.MAX_TEMP_CHANGES_PER_DAY) {
				count++;
			}
		}
		if (count == temp.length - 1) {
			result = true;
		}
		return result;
	}

	
	@Override
	public boolean isStabilityPress(double[] press) {

		boolean result = false;
		int count = 0;

		for (int i = 0; i < press.length - 1; i++) {
			double changeRange = Math.abs(press[i + 1] - press[i]);
			if (changeRange == 0 || changeRange <= ConstantsAnalyzer.MAX_PRESSURE_CHANGES_PER_DAY) {
				count++;
			}
		}
		if (count == press.length - 1) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isPressHigh(double[] press) {

		boolean result = false;
		int count = 0;

		for (int i = 0; i < press.length - 1; i++) {
			double changeRange = Math.abs(press[i + 1] - press[i]);
			if (changeRange == 0 || changeRange <= ConstantsAnalyzer.MAX_PRESSURE_CHANGES_FOR_STABILITY) {
				count++;
			}
		}
		if (count == press.length - 1) {
			count = 0;
			for (int i = 0; i < press.length; i++) {
				if (press[i] >= ConstantsAnalyzer.HIGH_PRESSURE_LEVEL) {
					count++;
				}
			}
		}
		if (count == press.length) {
			result = true;
		}
		return result;
	}


	@Override
	public boolean isPressLow(double[] press) {

		boolean result = false;
		int count = 0;

		for (int i = 0; i < press.length - 1; i++) {
			double changeRange = Math.abs(press[i + 1] - press[i]);
			if (changeRange == 0 || changeRange <= ConstantsAnalyzer.MAX_PRESSURE_CHANGES_FOR_STABILITY) {
				count++;
			}
		}
		if (count == press.length - 1) {
			count = 0;
			for (int i = 0; i < press.length; i++) {
				if (press[i] <= ConstantsAnalyzer.LOW_PRESSURE_LEVEL) {
					count++;
				}
			}
		}
		if (count == press.length) {
			result = true;
		}
		return result;
	}


	@Override
	public boolean isRisePressure(double[] press) {

		boolean result = false;
		int count = 0;

		for (int i = 0; i < press.length - 1; i++) {
			double changeRange = Math.abs(press[i + 1] - press[i]);
			if (changeRange == 0 || changeRange >= ConstantsAnalyzer.MAX_PRESSURE_CHANGES_FOR_STABILITY && changeRange <= ConstantsAnalyzer.MAX_PRESSURE_CHANGES_PER_DAY) {
				count++;
			}
		}
		if (count == press.length - 1) {
			if (press[press.length - 1] - press[0] > 0) {
				result = true;
			}
		}
		return result;
	}


	@Override
	public boolean isWindHelp(double temperature, double degrees, double speed) {

		boolean result = false;
		String direction = Utils.getDirection(degrees);

		if (speed > ConstantsAnalyzer.CRITICAL_WIND_SPEED) {
			return result;
		} else if (speed > ConstantsAnalyzer.MAX_WIND_SPEED && temperature > ConstantsAnalyzer.CRITICAL_HIGH_TEMP
				&& (direction.equals("N") || direction.equals("NNE") || direction.equals("NE")
						|| direction.equals("NNW"))) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean isRainHelp(double rainVolume, double[] temp) {

		boolean result = false;
		int count = 0;

		if (rainVolume <= ConstantsAnalyzer.MAX_RAIN_VOLUME) {

			for (int i = 0; i < temp.length - 1; i++) {
				if (temp[i] >= ConstantsAnalyzer.CRITICAL_HIGH_TEMP) {
					count++;
				}
			}
			if (count == temp.length - 1) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean isLongRain(double[] rains) {

		boolean result = false;
		int count = 0;

		for (int i = 0; i < rains.length; i++) {
			if (rains[i] > ConstantsAnalyzer.MIN_RAIN_VOLUME) {
				count++;
			}
		}
		if (count == rains.length) {
			result = true;
		}
		
		return result;
	}

	public static void main(String[] args) {
		WeatherChecker checker = new WeatherCheckerImpl();
		double[] press = new double[] { 744, 743, 741 };
		double[] temps = new double[] { 29, 30, 37, 22 };

		System.out.println("Is pressure stability: " + checker.isStabilityPress(press));
		System.out.println("Is pressure stability low: " + checker.isPressLow(press));
		System.out.println("Is pressure stability high: " + checker.isPressHigh(press));
		System.out.println("Is pressure rise: " + checker.isRisePressure(press));
		System.out.println("Is rain help: " + checker.isRainHelp(2.3, temps));
	}

}
