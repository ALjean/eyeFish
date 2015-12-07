package com.jean.analyzers.weather;

import java.util.ArrayList;
import java.util.List;

import com.jean.Constants;
import com.jean.model.owm.AverageWeatherParamsOWM;

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

	    if (generalChange > Constants.MAX_GENERAL_CHANGES) {
		return result = Constants.PERCENT_CHANGES / 2;
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
	    if (dayChange > Constants.CRITICAL_CHANGES) {
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
		countDay++;

		// In other case we compute result use usually methods.
	    } else {
		result += dayChange * Constants.PERCENT_CHANGES;
		countDay++;
	    }
	}
	
	/*
	 * Check result, if we have all period horrible changes, we return
	 * minimal value.
	 */
	if (result == 0) {
	    return result = Constants.PERCENT_CHANGES / 2;
	    
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
    public double windAnalyzer(Wind wind, double temperature) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public double pressureAnalyzer(int[] pressures, double temperature) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public double badWeatherAnalyzer(double rain, double clouds, double temperature) {
	// TODO Auto-generated method stub
	return 0;
    }

    public static void main(String[] args) {

	WeatherAnalyzer analyzer = new WeatherAnalyzerImpl();

	List<AverageWeatherParamsOWM> weatherState = new ArrayList<AverageWeatherParamsOWM>();

	weatherState.add(new AverageWeatherParamsOWM(32.3f));
	weatherState.add(new AverageWeatherParamsOWM(32.3f));
	weatherState.add(new AverageWeatherParamsOWM(32.3f));
	weatherState.add(new AverageWeatherParamsOWM(37f));
	weatherState.add(new AverageWeatherParamsOWM(35f));
	weatherState.add(new AverageWeatherParamsOWM(35f));
	weatherState.add(new AverageWeatherParamsOWM(36f));
	weatherState.add(new AverageWeatherParamsOWM(36f));
	weatherState.add(new AverageWeatherParamsOWM(36f));
	weatherState.add(new AverageWeatherParamsOWM(38f));

	float[] params = new float[weatherState.size()];
	int i = 0;

	for (AverageWeatherParamsOWM param : weatherState) {
	    params[i] = param.getTemp();
	    i++;
	}

	System.out.println(analyzer.StabilityChecker(params));

    }

}
