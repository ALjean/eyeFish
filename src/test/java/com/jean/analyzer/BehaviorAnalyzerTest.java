package com.jean.analyzer;

import com.jean.CustomDfmException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.jean.BaseTest;
import com.jean.DaoDfmException;
import com.jean.analyzers.fish.BehaviorDTO;
import com.jean.entity.Fish;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;
import com.jean.util.MapperOWM;

public class BehaviorAnalyzerTest extends BaseTest {

	private GeneralDayWeather generalDayWeather = null;
	private GeneralHourWeather generalHourWeather = null;
	private List<Fish> fish = null;

	@Before
	public void init() throws DaoDfmException, CustomDfmException {
		String lat = "50";
		String lon = "36.25";
		//GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = weatherService.getDetailWeatherState(lat, lon);
		GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = weatherApiService.getHourWeathers(lat, lon);

		//generalDayWeather = MapperOWM.buildModelDayWeather(dayWeatherOWM);
		generalHourWeather = MapperOWM.buildModelHourWeather(hourWeatherOWM);
		fish = fishDao.getFishes(7, null, null, null, null);
	}

	@Test
	public void getFishBehavior() throws DaoDfmException {

		List<HourWeather> hourWeathers = new ArrayList<HourWeather>();

		for (HourWeather hourWeather : generalHourWeather.getHourWeathers()) {
			if (hourWeather.getDateText().substring(0, 10).trim().equalsIgnoreCase("2016-07-18")) {
				hourWeathers.add(hourWeather);
			}
		}

		BehaviorDTO behaviorDTO = behaviorAnalyzer.getFishBehavior(hourWeathers, fish.get(0));

		System.out.println("\n" + behaviorDTO + "\n");
	}
}
