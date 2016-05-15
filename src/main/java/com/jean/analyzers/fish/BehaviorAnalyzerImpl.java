package com.jean.analyzers.fish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.WeatherAnalyzer;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;
import com.jean.entity.GeneralWeather;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;

@Component
public class BehaviorAnalyzerImpl implements BehaviorAnalyzer {

	@Autowired
	WeatherAnalyzer weatherAnalyzer;

	@Override
	public double getGeneralActivityLevel(GeneralWeather generalWeather) {
		
		double stabilityNibbleValue;
		double pressureNibbleValue;
		double windNibbleValue;
		
		double resultNibble;
		
		int count = generalWeather.getDayWeathers().size();
		
		double[] listTemps = new double[count];
		double[] listPressure  = new double[count];
		
        for(int i = 0; i < generalWeather.getDayWeathers().size(); i++){

			DayWeather dayWeather = generalWeather.getDayWeathers().get(i);
			
			listTemps[i] = dayWeather.getTempDay();
			listPressure[i] = dayWeather.getPressure();
		}
		
		double currentTemp = generalWeather.getDayWeathers().get(count - 1).getTempDay();
		double currentDegrees = generalWeather.getDayWeathers().get(count - 1).getWindDeg();
		double currentSpeed = generalWeather.getDayWeathers().get(count - 1).getWindSpeed();
		
		stabilityNibbleValue = weatherAnalyzer.stabilityChecker(listTemps);
		pressureNibbleValue = weatherAnalyzer.pressureChecker(listPressure);
		windNibbleValue = weatherAnalyzer.windChecker(currentTemp, currentDegrees, currentSpeed);
		
		resultNibble = (stabilityNibbleValue + pressureNibbleValue + windNibbleValue)/3;
		
		return resultNibble;
	}

	@Override
	public BehaviorDTO getFishBehavior(GeneralWeatherStateOWM<HoursWeatherDataOWM> hoursWeather, Fish fihs) {
		// TODO Auto-generated method stub
		return null;
	}

}
