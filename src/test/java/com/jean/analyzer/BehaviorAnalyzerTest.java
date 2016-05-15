package com.jean.analyzer;

import org.junit.Test;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

import org.junit.Before;

import com.jean.BaseTest;
import com.jean.entity.GeneralWeather;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;
import com.jean.util.MapperOWM;

public class BehaviorAnalyzerTest extends BaseTest {

	private GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = null;
	private GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = null;
	private GeneralWeather generalWeather = null;
	private String lat = "40.7143528";
	private String lon = "74.0059731";

	@Before
	public void inint() {
		dayWeatherOWM = weatherService.getDetailWeatherState(lat, lon);
		hourWeatherOWM = weatherService.getListWeatherState(lat, lon);
		generalWeather = MapperOWM.parseOWM(dayWeatherOWM, hourWeatherOWM);
	}

	@Test
	public void getGeneralActivityLevel() {
		double result = 0;
		result = behaviorAnalyzer.getGeneralActivityLevel(generalWeather);
		assertTrue(result > 0);
		System.out.println(result);

	}
}
