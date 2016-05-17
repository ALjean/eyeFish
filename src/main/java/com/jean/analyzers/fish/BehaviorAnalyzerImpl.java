package com.jean.analyzers.fish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.ConrolPointHolder;
import com.jean.analyzers.weather.WeatherAnalyzer;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;
import com.jean.entity.FishSetting;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.entity.NibblePeriod;
import com.jean.enums.ParamNames;

@Component
public class BehaviorAnalyzerImpl implements BehaviorAnalyzer {

	@Autowired
	WeatherAnalyzer weatherAnalyzer;

	@Override
	public double getGeneralActivityLevel(GeneralDayWeather generalWeather) {

		double stabilityNibbleValue;
		double pressureNibbleValue;
		double windNibbleValue;

		double resultNibble;

		int count = generalWeather.getDayWeathers().size();

		double[] listTemps = new double[count];
		double[] listPressure = new double[count];

		for (int i = 0; i < generalWeather.getDayWeathers().size(); i++) {

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

		resultNibble = (stabilityNibbleValue + pressureNibbleValue + windNibbleValue) / 3;

		return resultNibble;
	}

	@Override
	public BehaviorDTO getFishBehavior(GeneralHourWeather generalHourWeather, Fish fish, double generalNibble,
			String currentDate) {

		BehaviorDTO behaviorDTO = new BehaviorDTO();
		List<HourWeather> hourWeathers = new ArrayList<HourWeather>();

		for (HourWeather hourWeather : generalHourWeather.getHourWeathers()) {
			if (hourWeather.getDateText().substring(0, 10).trim().equalsIgnoreCase(currentDate)) {
				hourWeathers.add(hourWeather);
			}
		}

		for (HourWeather hourWeather : hourWeathers) {

			ConrolPointHolder pointHolder = new ConrolPointHolder();
			double nibble = 0;

			for (FishSetting fishSetting : fish.getFishSetting()) {

				boolean tempFirstFind = false;
				boolean pressureFirstFind = false;
				double temp = hourWeather.getGeneralTemp();
				double pressure = hourWeather.getPressure();

				if (fishSetting.getParamName().equals(ParamNames.ENVIRMOMENT_TEMPERATURE.name())
						&& (fishSetting.getMinValue() <= temp && temp <= fishSetting.getMaxValue()) && !tempFirstFind) {
					nibble += fishSetting.getNibbleLevel();
					tempFirstFind = true;
				}
				if (fishSetting.getParamName().equals(ParamNames.PRESSURE.name())
						&& (fishSetting.getMinValue() <= pressure && pressure <= fishSetting.getMaxValue()
								&& !pressureFirstFind)) {
					nibble += fishSetting.getNibbleLevel();
					pressureFirstFind = true;

				}
			}

			for (NibblePeriod period : fish.getNibbles()) {
				
			}

			pointHolder.setTime(hourWeather.getDateText().substring(10).trim());
			pointHolder.setNibbleLevel((nibble + generalNibble) / 3);

			behaviorDTO.getControlPoints().add(pointHolder);
		}

		return behaviorDTO;
	}

}
