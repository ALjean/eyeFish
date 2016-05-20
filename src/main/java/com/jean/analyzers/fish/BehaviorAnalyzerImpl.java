package com.jean.analyzers.fish;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.ConrolPointHolder;
import com.jean.analyzers.weather.ConstantsAnalyzer;
import com.jean.analyzers.weather.WeatherAnalyzer;
import com.jean.entity.DayActivity;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;
import com.jean.entity.FishSetting;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.entity.NibblePeriod;
import com.jean.enums.DaysActivity;
import com.jean.enums.ParamNames;

@Component
public class BehaviorAnalyzerImpl implements BehaviorAnalyzer {

	@Autowired
	private WeatherAnalyzer weatherAnalyzer;

	private Map<String, String> daysActivityHolder;

	@Override
	public double getGeneralActivityLevel(List<DayWeather> dayWeathers) {

		double stabilityNibbleValue;
		double pressureNibbleValue;
		double windNibbleValue;

		double resultNibble;

		int count = dayWeathers.size();

		double[] listTemps = new double[count];
		double[] listPressure = new double[count];

		for (int i = 0; i < dayWeathers.size(); i++) {

			DayWeather dayWeather = dayWeathers.get(i);

			listTemps[i] = dayWeather.getTempDay();
			listPressure[i] = dayWeather.getPressure();
		}

		double currentTemp = dayWeathers.get(count - 1).getTempDay();
		double currentDegrees = dayWeathers.get(count - 1).getWindDeg();
		double currentSpeed = dayWeathers.get(count - 1).getWindSpeed();

		stabilityNibbleValue = weatherAnalyzer.stabilityChecker(listTemps);
		pressureNibbleValue = weatherAnalyzer.pressureChecker(listPressure);
		windNibbleValue = weatherAnalyzer.windChecker(currentTemp, currentDegrees, currentSpeed);

		resultNibble = (stabilityNibbleValue + pressureNibbleValue + windNibbleValue) / 3;

		return resultNibble;
	}

	@Override
	public BehaviorDTO getFishBehavior(List<HourWeather> hourWeathers, Fish fish, double generalNibble) {

		BehaviorDTO behaviorDTO = new BehaviorDTO();

		int delimiter = 3;

		for (HourWeather hourWeather : hourWeathers) {

			ConrolPointHolder pointHolder = new ConrolPointHolder();
			double resultNibble = generalNibble;

			for (FishSetting fishSetting : fish.getFishSetting()) {
				resultNibble += checkFishSetting(fishSetting, hourWeather.getGeneralTemp(), hourWeather.getPressure());
			}

			for (NibblePeriod nibblePeriod : fish.getNibbles()) {
				resultNibble += checkNibblePeriod(nibblePeriod, hourWeather.getDate());
			}

			pointHolder.setNibbleLevel(resultNibble / delimiter);
			pointHolder.setMessage("Some text");
			behaviorDTO.getControlPoints().add(pointHolder);
		}

		return behaviorDTO;
	}

	private double checkFishSetting(FishSetting fishSetting, double temp, double pressure) {

		double nibble = 0.0;

		if (fishSetting.getParamName().equals(ParamNames.ENVIRMOMENT_TEMPERATURE.name())
				&& (fishSetting.getMinValue() <= temp && temp <= fishSetting.getMaxValue())) {
			nibble += fishSetting.getNibbleLevel();
		}
		if (fishSetting.getParamName().equals(ParamNames.PRESSURE.name())
				&& (fishSetting.getMinValue() <= pressure && pressure <= fishSetting.getMaxValue())) {
			nibble += fishSetting.getNibbleLevel();
		}
		return nibble;
	}

	private double checkNibblePeriod(NibblePeriod nibblePeriod, Date date) {

		if (date.after(nibblePeriod.getEndPeriod()) && date.before(nibblePeriod.getEndPeriod())) {
			return nibblePeriod.getNibbleLevel();
		} else {
			return 0;
		}

	}

	public BehaviorAnalyzerImpl() {
		this.daysActivityHolder = new HashMap<String, String>();

		daysActivityHolder.put("21:00:00", DaysActivity.NIGHT.name());
		daysActivityHolder.put("00:00:00", DaysActivity.NIGHT.name());
		daysActivityHolder.put("03:00:00", DaysActivity.NIGHT.name());

		daysActivityHolder.put("06:00:00", DaysActivity.MORNING.name());
		daysActivityHolder.put("09:00:00", DaysActivity.MORNING.name());

		daysActivityHolder.put("12:00:00", DaysActivity.DAY.name());
		daysActivityHolder.put("15:00:00", DaysActivity.DAY.name());

		daysActivityHolder.put("18:00:00", DaysActivity.EVENING.name());

	}

}
