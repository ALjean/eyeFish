package com.jean.util;

import java.util.ArrayList;
import java.util.List;

import com.jean.entity.DayWeather;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;

public class MapperOWM {

	public static GeneralDayWeather buildModelDayWeather(GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM) {

		GeneralDayWeather generalDayWeather = new GeneralDayWeather();
		List<DayWeather> dayWeathers = new ArrayList<DayWeather>();

		generalDayWeather.setCityId((dayWeatherOWM.getCity().getId()));
		generalDayWeather.setCityName(dayWeatherOWM.getCity().getName());
		generalDayWeather.setCountry(dayWeatherOWM.getCity().getCountry());
		generalDayWeather.setCoordLat(dayWeatherOWM.getCity().getCoord().getLat());
		generalDayWeather.setCoordLon(dayWeatherOWM.getCity().getCoord().getLon());

		for (DayWeatherDataOWM dayWeatherDataOWM : dayWeatherOWM.getList()) {

			DayWeather dayWeather = new DayWeather();

			dayWeather.setClouds(dayWeatherDataOWM.getClouds());
			dayWeather.setCurrentDate(dayWeatherDataOWM.getDt());
			dayWeather.setHumidity(dayWeatherDataOWM.getHumidity());
			dayWeather.setPressure(Utils.millibarToMmHg(dayWeatherDataOWM.getPressure()));
			dayWeather.setRainVolume(dayWeatherDataOWM.getRain());
			dayWeather.setTempDay(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getDay()));
			dayWeather.setTempEvening(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getEve()));
			dayWeather.setTempMorning(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getMorn()));
			dayWeather.setTempNight(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getNight()));
			dayWeather.setTempMin(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getMin()));
			dayWeather.setTempMax(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getMax()));
			dayWeather.setWindDeg(dayWeatherDataOWM.getDeg());
			dayWeather.setWindSpeed(dayWeatherDataOWM.getSpeed());
			dayWeather.setClouds(dayWeatherDataOWM.getClouds());

			dayWeathers.add(dayWeather);
		}

		generalDayWeather.getDayWeathers().addAll(dayWeathers);

		return generalDayWeather;

	}

	public static GeneralHourWeather buildModelHourWeather(GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM) {

		GeneralHourWeather generalHourWeather = new GeneralHourWeather();
		List<HourWeather> hourWeathers = new ArrayList<HourWeather>();

		generalHourWeather.setCityId((hourWeatherOWM.getCity().getId()));
		generalHourWeather.setCityName(hourWeatherOWM.getCity().getName());
		generalHourWeather.setCountry(hourWeatherOWM.getCity().getCountry());
		generalHourWeather.setCoordLat(hourWeatherOWM.getCity().getCoord().getLat());
		generalHourWeather.setCoordLon(hourWeatherOWM.getCity().getCoord().getLon());

		for (HoursWeatherDataOWM hoursWeatherDataOWM : hourWeatherOWM.getList()) {

			HourWeather hourWeather = new HourWeather();

			hourWeather.setClouds(hoursWeatherDataOWM.getClouds().getAll());
			hourWeather.setDateText(hoursWeatherDataOWM.getDt_txt());
			hourWeather.setGeneralTemp(Utils.kelvinToCelsius(hoursWeatherDataOWM.getMain().getTemp()));
			hourWeather.setTempMin(Utils.kelvinToCelsius(hoursWeatherDataOWM.getMain().getTemp_min()));
			hourWeather.setTempMax(Utils.kelvinToCelsius(hoursWeatherDataOWM.getMain().getTemp_max()));
			hourWeather.setPressure(Utils.millibarToMmHg(hoursWeatherDataOWM.getMain().getPressure()));
			hourWeather.setHumadity(hoursWeatherDataOWM.getMain().getPressure());
			hourWeather.setRainVolume(hoursWeatherDataOWM.getRain().getVolume());
			hourWeather.setSeaLevel(hoursWeatherDataOWM.getMain().getSea_level());
			hourWeather.setWindDeg(hoursWeatherDataOWM.getWind().getDeg());
			hourWeather.setWindSpeed(hoursWeatherDataOWM.getWind().getSpeed());

			hourWeathers.add(hourWeather);

		}

		generalHourWeather.getHourWeathers().addAll(hourWeathers);

		return generalHourWeather;

	}
}
