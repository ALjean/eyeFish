package com.jean.util;

import static org.junit.Assert.*;
import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.owm.GeneralWeatherStateOWM;
import com.jean.entity.owm.detail.DayWeatherDataOWM;
import com.jean.entity.owm.hour.HoursWeatherDataOWM;

import com.jean.entity.weather.GeneralDayWeather;
import com.jean.entity.weather.GeneralHourWeather;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by root on 18.07.15.
 */
public class UtilsTest extends BaseTest {

	private float input = 295;

	private GeneralDayWeather dayWeatherOWM = null;
	private GeneralHourWeather hourWeatherOWM = null;
	private String lat = "40.7143528";
	private String lon = "74.0059731";

	@Before
	public void init() throws CustomDfmException {

		dayWeatherOWM = weatherService.getGeneralDayWeather(lat, lon);
		hourWeatherOWM = weatherService.getGeneralHourWeather(lat, lon);
	}

	@Test
	@Ignore
	public void kelvinToCelsiusTest() {
		float result = Utils.kelvinToCelsius(input);
		System.out.println(result);
	}

}
