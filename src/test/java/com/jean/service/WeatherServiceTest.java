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

		GeneralWeatherStateOWM<HoursWeatherDataOWM> hoursWeatherStateOWM = null;

		hoursWeatherStateOWM = weatherService.getHoursWeatherState();
		assertTrue(hoursWeatherStateOWM.getList().get(0).getClass().equals(HoursWeatherDataOWM.class));
	}

	@Test

	public void testGetDayWeatherStateForListCheckListGenericType() {
		
		GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherStateOWM = null;
		
		dayWeatherStateOWM = weatherService.getDayWeatherState();
		assertTrue(dayWeatherStateOWM.getList().get(0).getClass().equals(DayWeatherDataOWM.class));

	}

}
