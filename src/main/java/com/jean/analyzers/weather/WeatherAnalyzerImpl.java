package com.jean.analyzers.weather;

import java.util.ArrayList;
import java.util.List;

import com.jean.Constants;
import com.jean.model.owm.AverageWeatherParamsOWM;

public class WeatherAnalyzerImpl implements WeatherAnalyzer {

    @Override
    public double weatherStateAnalyzer(List<AverageWeatherParamsOWM> weatherState) {

	double result = 0;
	int countDay = 1;

	float mainChange = Math.abs((weatherState.get(weatherState.size() - 1).getTemp() - weatherState.get(0).getTemp()));

	if (mainChange > Constants.MAX_TEMP_CHANGES) {
	    return result = Constants.PERCENT_CHANGES / 2;
	}

	for (int i = 0; i < weatherState.size() - 1; i++) {

	    float changesTemp = Math.abs(weatherState.get(i + 1).getTemp() - weatherState.get(i).getTemp());
	    System.out.println(changesTemp);

	    if (changesTemp > Constants.CRITICAL_CHANGES) {
		result = 0;
		countDay = 0;
	    } else {
		if (changesTemp == 0) {
		    result += 0.01;
		    countDay++;
		} else {
		    result += changesTemp * Constants.PERCENT_CHANGES;
		    countDay++;
		}
	    }
	}
	if (result == 0) {
	    return result = Constants.PERCENT_CHANGES / 2;
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

	System.out.println(analyzer.weatherStateAnalyzer(weatherState));

    }

}
