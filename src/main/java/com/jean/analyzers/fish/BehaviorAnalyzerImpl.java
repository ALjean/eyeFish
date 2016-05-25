package com.jean.analyzers.fish;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.ConrolPointHolder;
import com.jean.analyzers.weather.ConstantsAnalyzer;
import com.jean.analyzers.weather.WeatherChecker;
import com.jean.entity.DayActivity;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;
import com.jean.entity.FishSetting;
import com.jean.entity.HourWeather;
import com.jean.entity.NibblePeriod;
import com.jean.enums.DaysActivity;
import com.jean.enums.ParamNames;
import com.mysql.fabric.xmlrpc.base.Array;

@Component
public class BehaviorAnalyzerImpl implements BehaviorAnalyzer {

	@Autowired
	private WeatherChecker weatherChecker;

	@Override
	public double getGeneralActivityLevel(List<DayWeather> dayWeathers) {

		double result = 0;
		double[] press = new double[dayWeathers.size() - 1];
		double[] temps = new double[dayWeathers.size() - 1];

		for (int i = 0; i < dayWeathers.size() - 1; i++) {
			DayWeather dayWeather = dayWeathers.get(i);
			press[i] = dayWeather.getPressure();
			temps[i] = dayWeather.getTempDay();
		}

		result = weatherChecker.checkPressure(press) + weatherChecker.checkTemperature(temps)
				+ weatherChecker.checkWind(dayWeathers.get(dayWeathers.size() - 1).getWindDeg(),
						dayWeathers.get(dayWeathers.size() - 1).getWindSpeed())
				+ weatherChecker.isRain(dayWeathers.get(dayWeathers.size() - 1).getRainVolume());

		return perfomanceToCustomer(result);
	}

	@Override
	public BehaviorDTO getFishBehavior(List<HourWeather> hourWeathers, Fish fish, double generalNibble) {

		BehaviorDTO behaviorDTO = new BehaviorDTO();

		for (HourWeather hourWeather : hourWeathers) {

			double result = 0;
			ConrolPointHolder conrolPoint = new ConrolPointHolder();

			String time = hourWeather.getDateText().substring(11);

			for (FishSetting fishSetting : fish.getFishSetting()) {
				if (ParamNames.ENVIRMOMENT_TEMPERATURE.name().equals(fishSetting.getParamName()) && (hourWeather.getGeneralTemp() > fishSetting.getMinValue()
								&& hourWeather.getGeneralTemp() < fishSetting.getMaxValue())) {
					result += fishSetting.getNibbleLevel();
				}
				if (ParamNames.PRESSURE.name().equals(fishSetting.getParamName()) && (hourWeather.getPressure() > fishSetting.getMinValue()
								&& hourWeather.getPressure() <= fishSetting.getMaxValue())) {
					result += fishSetting.getNibbleLevel();
				}
			}

			Date date = null;
			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				date = formatter.parse(hourWeather.getDateText().substring(0, 11));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (NibblePeriod nibblePeriod : fish.getNibbles()) {
				if (date.after(nibblePeriod.getStartPeriod()) && date.before(nibblePeriod.getEndPeriod())) {
					result += nibblePeriod.getNibbleLevel();
				}
			}

			for (DayActivity dayActivity : fish.getDaysActivity()) {
				if (dayActivity.getActivityName().equals(DaysActivity.MORNING.name())
						&& (time.equals("6:00:00") || time.equals("9:00:00"))) {
					result += ConstantsAnalyzer.DAY_ACTIVITY_POINT;
				}
				if (dayActivity.getActivityName().equals(DaysActivity.DAY.name())
						&& (time.equals("9:00:00") || time.equals("12:00:00") || time.equals("15:00:00"))) {
					result += ConstantsAnalyzer.DAY_ACTIVITY_POINT;
				}
				if (dayActivity.getActivityName().equals(DaysActivity.EVENING.name())
						&& (time.equals("18:00:00") || time.equals("21:00:00"))) {
					result += ConstantsAnalyzer.DAY_ACTIVITY_POINT;
				}
				if (dayActivity.getActivityName().equals(DaysActivity.NIGHT.name())
						&& (time.equals("00:00:00") || time.equals("3:00:00"))) {
					result += ConstantsAnalyzer.DAY_ACTIVITY_POINT;
				}
			}

			conrolPoint.setNibbleLevel(perfomanceToCustomer(result / 4));
			conrolPoint.setTime(hourWeather.getDateText().substring(11));
			conrolPoint.setMessage("some text");
			behaviorDTO.getControlPoints().add(conrolPoint);
		}
		return behaviorDTO;

	}

	private double perfomanceToCustomer(double result) {
		return result + (5 * Math.random());
	}

}
