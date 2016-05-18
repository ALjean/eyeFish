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

		double nibblePeriodLevel = 0;
		int delimiter = 3;
		BehaviorDTO behaviorDTO = new BehaviorDTO();
		List<HourWeather> hourWeathers = new ArrayList<HourWeather>();

		for (HourWeather hourWeather : generalHourWeather.getHourWeathers()) {
			String s = hourWeather.getDateText().substring(0, 10).trim();
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

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;

			try {
				date = formatter.parse(currentDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (NibblePeriod period : fish.getNibbles()) {
				if (date.after(period.getEndPeriod()) && date.before(period.getEndPeriod())) {
					nibblePeriodLevel = period.getNibbleLevel();
					break;
				}
			}

			String time = hourWeather.getDateText().substring(10).trim();
			String activity = daysActivityHolder.get(time);

			pointHolder.setTime(time);

			for (DayActivity dayActivity : fish.getDaysActivity()) {
				if (dayActivity.getActivityName().equalsIgnoreCase(activity)) {
					nibble += 100;
					delimiter++;
				}
			}

			pointHolder.setNibbleLevel((nibble + generalNibble + nibblePeriodLevel) / delimiter);
			behaviorDTO.getControlPoints().add(pointHolder);
		}

		return behaviorDTO;
	}

	private double checkFishSetting(FishSetting fishSetting, double temp, double pressure) {

		double nibble = 0.0;
		boolean tempFirstFind = false;
		boolean pressureFirstFind = false;

		if (fishSetting.getParamName().equals(ParamNames.ENVIRMOMENT_TEMPERATURE.name())
				&& (fishSetting.getMinValue() <= temp && temp <= fishSetting.getMaxValue()) && !tempFirstFind) {
			nibble += fishSetting.getNibbleLevel();
			tempFirstFind = true;
		}
		if (fishSetting.getParamName().equals(ParamNames.PRESSURE.name()) && (fishSetting.getMinValue() <= pressure
				&& pressure <= fishSetting.getMaxValue() && !pressureFirstFind)) {
			nibble += fishSetting.getNibbleLevel();
			pressureFirstFind = true;
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

		daysActivityHolder.put("00:00:00", DaysActivity.NIGHT.name());
		daysActivityHolder.put("03:00:00", DaysActivity.NIGHT.name());

		daysActivityHolder.put("06:00:00", DaysActivity.MORNING.name());
		daysActivityHolder.put("09:00:00", DaysActivity.MORNING.name());

		daysActivityHolder.put("12:00:00", DaysActivity.DAY.name());
		daysActivityHolder.put("15:00:00", DaysActivity.DAY.name());

		daysActivityHolder.put("18:00:00", DaysActivity.EVENING.name());
		daysActivityHolder.put("21:00:00", DaysActivity.EVENING.name());
	}

}
