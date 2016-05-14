package com.jean.analyzers.fish;

import org.springframework.beans.factory.annotation.Autowired;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.WeatherAnalyzer;
import com.jean.entity.Fish;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;

public class BehaviorAnalyzerImpl implements BehaviorAnalyzer {

	@Autowired
	WeatherAnalyzer weatherAnalyze;

	@Override
	public double getGeneralActivityLevel(GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeather) {
		
		double stabilityNibbleValue;
		double pressureNibbleValue;
		double windNibbleValue;
		
		double resultNibble;
		
		int count = dayWeather.getList().size();
		
		float[] listTemps = new float[count];
		float[] listPressure  = new float[count];
		
        for(int i = 0; i < dayWeather.getList().size(); i++){

			DayWeatherDataOWM dayWeatherOWM = dayWeather.getList().get(i);
			
			listTemps[i] = dayWeatherOWM.getTemp().getDay();
			listPressure[i] = dayWeatherOWM.getPressure();
		}
		
		double currentTemp = dayWeather.getList().get(count - 1).getTemp().getDay();
		double currentDegrees = dayWeather.getList().get(count - 1).getDeg();
		double currentSpeed = dayWeather.getList().get(count - 1).getSpeed();
		
		stabilityNibbleValue = weatherAnalyze.stabilityChecker(listTemps);
		pressureNibbleValue = weatherAnalyze.pressureChecker(listPressure);
		windNibbleValue = weatherAnalyze.windChecker(currentTemp, currentDegrees, currentSpeed);
		
		resultNibble = (stabilityNibbleValue + pressureNibbleValue + windNibbleValue)/3;
		
		return resultNibble;
	}

	@Override
	public BehaviorDTO getFishBehavior(GeneralWeatherStateOWM<HoursWeatherDataOWM> hoursWeather, Fish fihs) {
		// TODO Auto-generated method stub
		return null;
	}

}
