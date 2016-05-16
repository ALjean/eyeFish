package com.jean.util;

import static org.junit.Assert.*;
import com.jean.BaseTest;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by root on 18.07.15.
 */
public class UtilsTest extends BaseTest {

	private float input = 295;

	private GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = null;
	private GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = null;
	private String lat = "40.7143528";
	private String lon = "74.0059731";

	@Before
	public void init() {

		dayWeatherOWM = weatherService.getDetailWeatherState(lat, lon);
		hourWeatherOWM = weatherService.getListWeatherState(lat, lon);
	}

	@Test
	@Ignore
	public void kelvinToCelsiusTest() {
		float result = Utils.kelvinToCelsius(input);
		System.out.println(result);
	}

}
