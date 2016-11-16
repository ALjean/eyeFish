package com.jean.service;

import static org.junit.Assert.*;
import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.owm.GeneralWeatherStateOWM;
import com.jean.entity.owm.current.CurrentWeatherOWM;
import com.jean.entity.owm.detail.DayWeatherDataOWM;
import com.jean.entity.owm.hour.HoursWeatherDataOWM;

import com.jean.entity.weather.GeneralDayWeather;
import com.jean.entity.weather.GeneralHourWeather;
import org.junit.Test;

public class WeatherServiceTest extends BaseTest {

	@Test
	public void testGetDetailWeatherState() throws CustomDfmException {
		String lat = "40.7143528";
		String log = "74.0059731";

		GeneralDayWeather hoursWeatherStateOWM = weatherService.getGeneralDayWeather(lat, log);
//		assertTrue(hoursWeatherStateOWM.getList().get(0).getClass().equals(DayWeatherDataOWM.class));
	}

	@Test
	public void testGetCurrentWeatherState(){
		String lat = "40.7143528";
		String log = "74.0059731";

		CurrentWeatherOWM currentWeatherOWM = weatherService.getCurrentWeatherState(lat, log);
		assertTrue(currentWeatherOWM.getClass().equals(CurrentWeatherOWM.class));
	}

	@Test
	public void testGetListWeatherState() throws CustomDfmException {
		String lat = "40.7143528";
		String log = "74.0059731";

		GeneralHourWeather dayWeatherStateOWM = weatherService.getGeneralHourWeather(lat, log);
//		assertTrue((dayWeatherStateOWM.getList().get(0)).getClass().equals(HoursWeatherDataOWM.class));
//		assertTrue(hoursWeatherStateOWM.getList().get(0).getClass().equals(HoursWeatherDataOWM.class));

	}

}
