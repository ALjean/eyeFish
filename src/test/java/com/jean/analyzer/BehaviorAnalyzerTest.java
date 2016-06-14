package com.jean.analyzer;

import org.junit.Test;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.jean.BaseTest;
import com.jean.DaoDfmException;
import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.analyzers.weather.GeneralNibbleState;
import com.jean.entity.DayWeather;
import com.jean.entity.Fish;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.enums.DaysActivity;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;
import com.jean.util.MapperOWM;

public class BehaviorAnalyzerTest extends BaseTest {

	private GeneralDayWeather generalDayWeather = null;
	private GeneralHourWeather generalHourWeather = null;
	private List<Fish> fish = null;

	@Before
	public void init() throws DaoDfmException {
		String lat = "50";
		String lon = "36.25";
		//GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = weatherService.getDetailWeatherState(lat, lon);
		GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = weatherService.getHourWeathers(lat, lon);

		//generalDayWeather = MapperOWM.buildModelDayWeather(dayWeatherOWM);
		generalHourWeather = MapperOWM.buildModelHourWeather(hourWeatherOWM);
		fish = fishDao.getFishes(7, null, null, null, null);
	}

	@Test
	public void getFishBehavior() throws DaoDfmException {

		List<HourWeather> hourWeathers = new ArrayList<HourWeather>();
		
		for (HourWeather hourWeather : generalHourWeather.getHourWeathers()) {
			if (hourWeather.getDateText().substring(0, 10).trim().equalsIgnoreCase("2016-06-09")) {
				hourWeathers.add(hourWeather);
			}
		}
		
		BehaviorDTO behaviorDTO = behaviorAnalyzer.getFishBehavior(hourWeathers, fish.get(0));

		System.out.println("\n" + behaviorDTO + "\n");
	}
}
