package com.jean.analyzers.fish;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.ConstantsAnalyzer;
import com.jean.analyzers.weather.WeatherChecker;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;

import com.jean.entity.HourWeather;
import com.mysql.fabric.xmlrpc.base.Array;

@Component
public class BehaviorAnalyzerImpl implements BehaviorAnalyzer {

	@Autowired
	private WeatherChecker weatherChecker;

	@Override
	public double getGeneralActivityLevel(List<DayWeather> dayWeathers) {

		double point = 0;
		double[] pressures = new double[dayWeathers.size() - 1];
		double[] temps = new double[dayWeathers.size() - 1];
		double[] rains = new double[dayWeathers.size() - 1];

		for (int i = 0; i < dayWeathers.size() - 1; i++) {
			DayWeather dayWeather = dayWeathers.get(i);
			pressures[i] = dayWeather.getPressure();
			temps[i] = dayWeather.getTempDay();
			rains[i] = dayWeather.getRainVolume();
		}

		if (weatherChecker.isStabilityPress(pressures)) {

			if (weatherChecker.isPressHigh(pressures)) {
				point += ConstantsAnalyzer.HIGH_PRESSURE_POINT;
			}
			if (weatherChecker.isPressLow(pressures)) {
				point += ConstantsAnalyzer.LOW_PRESSURE_POINT;
			}
			if (weatherChecker.isRisePressure(pressures)) {
				point += ConstantsAnalyzer.RISE_PRESSURE_POINT;
			} else {
				point += ConstantsAnalyzer.DOWN_PRESSURE_POINT;
			}
		} else {
			point += ConstantsAnalyzer.UNSTABILITY_PRESSURE_POINT;
		}
		if (point == 0) {
			point = ConstantsAnalyzer.STABILITY_PRESSURE_POINT;
		}

		if (weatherChecker.isStabilityTemp(temps)) {
			point += ConstantsAnalyzer.STABILITY_TEMP_POINT;
		}
		if (!weatherChecker.isLongRain(rains)) {
			if (weatherChecker.isRainHelp(rains[rains.length - 1], temps)) {
				point += ConstantsAnalyzer.RAIN_HELP_POINT;
			}
		}
		if (weatherChecker.isWindHelp(temps[temps.length - 1], dayWeathers.get(dayWeathers.size() - 1).getWindDeg(),
				dayWeathers.get(dayWeathers.size() - 1).getWindSpeed())) {
			point += ConstantsAnalyzer.WIND_HELP_POINT;
		}

		return point;

	}

	@Override
	public BehaviorDTO getFishBehavior(List<HourWeather> hourWeathers, Fish fish, double generalNibble) {
		return null;

	}

}
