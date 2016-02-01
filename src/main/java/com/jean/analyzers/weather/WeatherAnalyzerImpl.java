package com.jean.analyzers.weather;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.jean.analyzers.weather.WindDirectionConverter.DirectionMap;
import com.jean.analyzers.weather.WindDirectionConverter.MinMaxHolder;

public class WeatherAnalyzerImpl implements WeatherAnalyzer {

    @Override
    public double StabilityChecker(float[] temperatureParams) {

	// Result should be represented in percent.
	double result = 0;

	// Amount of day which take part in analyze process.
	int countDay = 1;

	// General temperature changes during period of compute.
	float generalChange = Math.abs((temperatureParams[temperatureParams.length - 1] - temperatureParams[0]));

	for (int i = 0; i < temperatureParams.length - 1; i++) {

	    if (generalChange > ConstantsAnalyzer.MAX_GENERAL_TEMPERATURE_CHANGES) {
		return ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES / 2;
	    }

	    /*
	     * Changes which had happened between different days (for example)
	     * or two different values of temperature.
	     */
	    float dayChange = Math.abs(temperatureParams[i + 1] - temperatureParams[i]);

	    /*
	     * If changes during the day have critical character, we must
	     * analyze next part of data - after critical point. We reset amount
	     * of day and finally result, and try compute again.
	     */
	    if (dayChange > ConstantsAnalyzer.CRITICAL_TEMPERATURE_CHANGES) {
		result = 0;
		countDay = 0;
	    }

	    /*
	     * If we didn't have any changes, we have added to the result 0.01
	     * "percent changes" (it's like "badly percent" - the more the
	     * worse). Also we have increment count of day, because it,s
	     * "normal day" and he should take part in finally compute of
	     * result.
	     */
	    if (dayChange == 0) {
		result += 0.01;

		// In other case we compute result use usually methods.
	    } else {
		result += dayChange * ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES;
	    }

	    countDay++;
	}

	/*
	 * Check result, if we have all period horrible changes, we return
	 * minimal value.
	 */
	if (result == 0) {
	    return ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES / 2;

	    /*
	     * Return finally result. It's mean value for all compute period -
	     * that's why we reseted count of day. And finally we subtracted 100
	     * from result, because we have "badly percent", but we need
	     * "percent of activity"
	     */
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

	    if (temperature > ConstantsAnalyzer.CRITICAL_HIGH_TEMPERATURE && (direction.equals("N") | direction.equalsIgnoreCase("NNE")
		    | direction.equalsIgnoreCase("NE") | direction.equalsIgnoreCase("NNW"))) {

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
    public double pressureChecker(float[] pressureParams) {

	double result = 0;

	float generalChange = pressureParams[pressureParams.length - 1] - pressureParams[0];

	if (Math.abs(generalChange) > ConstantsAnalyzer.CRITICAL_PRESSURE_CHANGES) {
	    return ConstantsAnalyzer.CRITICAL_PRESSURE_CHANGES / 2;
	}
	if (generalChange == 0 || generalChange > 0) {
	    return ConstantsAnalyzer.PERCENT_PRESSURE_CHANGES * ConstantsAnalyzer.CRITICAL_PRESSURE_CHANGES;
	}
	if (generalChange < 0) {
	    return Math.abs(Math.abs(generalChange) * ConstantsAnalyzer.PERCENT_PRESSURE_CHANGES / pressureParams.length - 100);
	}

	return result;
    }

    public static void main(String[] args) {

	WeatherAnalyzer analyzer = new WeatherAnalyzerImpl();

	float[] temperatureParams = { 32.5f, 32.8f, 33f, 33.5f, 31.2f };

	float[] pressureParams = { 740.25f, 742.3f, 743f, 743.4f, 736f };

	System.out.println("Stability of weather are: " + analyzer.StabilityChecker(temperatureParams));

	System.out.println("Pressure activity are: " + analyzer.pressureChecker(pressureParams));

	System.out.println("Wind activity is " + analyzer.windChecker(32, 348, 5.6));

	Timestamp time = new Timestamp(1406106000l);
	SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
	String s = df2.format(time);
	System.out.println(s);

    }

}
