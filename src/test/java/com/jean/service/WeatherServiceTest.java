package com.jean.service;

import static org.junit.Assert.*;
import com.jean.BaseTest;
import com.jean.servlet.model.owm.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.HoursWeatherDataOWM;

import org.junit.Ignore;
import org.junit.Test;

public class WeatherServiceTest extends BaseTest {

	@Test
	public void testGetHoursWeatherStateForCheckListGenericType() {
		String lat = "40.7143528";
		String log = "-74.0059731";


		GeneralWeatherStateOWM<HoursWeatherDataOWM> hoursWeatherStateOWM = weatherService.getHoursWeatherState(lat, log);
		assertTrue(hoursWeatherStateOWM.getList().get(0).getClass().equals(HoursWeatherDataOWM.class));
	}

	@Test
	public void testGetDayWeatherStateForListCheckListGenericType() {
		String lat = "40.7143528";
		String log = "-74.0059731";

		GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherStateOWM = weatherService.getDayWeatherState(lat, log);
		assertTrue(dayWeatherStateOWM.getList().get(0).getClass().equals(DayWeatherDataOWM.class));

	}

}
